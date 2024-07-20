import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5547 {

	static int W,H;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W= Integer.parseInt(st.nextToken());
		H= Integer.parseInt(st.nextToken());
		boolean map[][] = new boolean[H+2][W+2];
		for(int h=1;h<=H;h++) {
			st = new StringTokenizer(br.readLine());
			for(int w=1;w<=W;w++) {
				if(Integer.parseInt(st.nextToken())==1) {
					map[h][w] = true;
				}
			}
		}
		int deltaA[][] = {{-1,0},{-1,1},{0,-1},{0,1},{1,0},{1,1}};//홀
		int deltaB[][] = {{-1,-1},{-1,0},{0,-1},{0,1},{1,-1},{1,0}};//짝
		//오른쪽 위/왼쪽 위/왼쪽/오른쪽/오른쪽 아래/왼쪽 아래 
		
		boolean visited[][] = new boolean[H+2][W+2];
		Queue<int[]> que= new ArrayDeque<>();
		que.add(new int[] {0,0});
		visited[0][0]=true;
		while(!que.isEmpty()) {
			int h=que.peek()[0];
			int w=que.peek()[1];
			que.poll();
			for(int d=0;d<6;d++) {
				int wd=0;
				int hd=0;
				if(h%2==1) {
					hd = h+deltaA[d][0];
					wd = w+deltaA[d][1];
				}else {
					hd = h+deltaB[d][0];
					wd = w+deltaB[d][1];
				}
				if(isIn(hd,wd)&&!map[hd][wd]&&!visited[hd][wd]) {
					visited[hd][wd]=true;
					que.add(new int[] {hd,wd});
				}
			}
		}
		
		int cnt = 0;
		for(int h=1;h<=H;h++) {
			for(int w=1;w<=W;w++) {
				if(visited[h][w])continue;
				for(int d=0;d<6;d++) {
					int wd=0;
					int hd=0;
					if(h%2==1) {
						hd = h+deltaA[d][0];
						wd = w+deltaA[d][1];
					}else {
						hd = h+deltaB[d][0];
						wd = w+deltaB[d][1];
					}
					
					if(visited[hd][wd]||!isIn(hd,wd))cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	private static boolean isIn(int row, int col) {
		return 0<=row&&row<H+2&&0<=col&&col<W+2?true:false;
	}

}
