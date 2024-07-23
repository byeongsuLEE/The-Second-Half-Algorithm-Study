import java.util.*;
import java.io.*;

public class BOJ_14712 {
	static int N, M;
	static boolean[][] visit;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N][M];
		DFS(0, 0);
		
		System.out.println(answer);
	}
	
	static void DFS(int depth, int start) {
		// 넴모가 0개부터 N * M개까지 존재할 수 있으므로 모든 경우를 카운트
		answer += check(depth) ? 1 : 0; 
		if(depth == N * M) // 넴모를 모두 채운 경우 DFS 끝내기
			return;

		for(int i=start;i<N*M;i++) {
			int r = i / M;
			int c = i % M;
			if(visit[r][c])
				continue;
			visit[r][c] = true;
			DFS(depth + 1, i + 1);
			visit[r][c] = false;
		}
		
	}
	
	// 없앨 수 있는 넴모가 없으면 true, 있으면 false
	static boolean check(int depth) {
		if(depth < 4) // 넴모가 세개 이하인 경우 없앨 수 없음
			return true;
		
		for(int i=0;i<N-1;i++)
			for(int j=0;j<M-1;j++) 
				if(visit[i][j] && visit[i][j + 1] && visit[i + 1][j] && visit[i + 1][j + 1])
					return false;
		return true;
	}

}
