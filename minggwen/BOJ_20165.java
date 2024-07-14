import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20165 {

	static int cnt = 0;
	static int[][] map;
	static char[][] answer;
	static int[][] delta = {{0,1},{0,-1},{1,0},{-1,0}};
	static int N,M,R;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		answer = new char[N][M];
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0;m<M;m++) {
				map[n][m]=Integer.parseInt(st.nextToken());
			}
		}
		for(char a[]:answer) {
			Arrays.fill(a, 'S');
		}
		for(int r=0;r<R;r++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			char d= st.nextToken().charAt(0);
			int del=0;
			if(d=='E')del=0;
			else if(d=='W')del=1;
			else if(d=='S')del=2;
			else if(d=='N')del=3;
			attack(x,y,del);
			st = new StringTokenizer(br.readLine());
			x=Integer.parseInt(st.nextToken())-1;
			y=Integer.parseInt(st.nextToken())-1;
			answer[x][y]='S';
			
		}
		System.out.println(cnt);
		for(int n=0;n<N;n++) {
			for(int m=0;m<M;m++) {
				System.out.print(answer[n][m]+" ");
			}
			System.out.println();
		}

	}
	private static void attack(int row, int col, int d) {
		if(answer[row][col]=='F')return;
		Queue<int[]> que = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		que.add(new int[] {row,col});
		visited[row][col] = true;
		while(!que.isEmpty()) {
			int r=que.peek()[0];
			int c=que.peek()[1];
			que.poll();
			if(answer[r][c]=='F')continue;
			answer[r][c] = 'F';
			cnt++;
			for(int del=1;del<map[r][c];del++) {
				int rd = r+delta[d][0]*del;
				int cd = c+delta[d][1]*del;
				if(isIn(rd,cd)&&!visited[rd][cd]) {
					visited[rd][cd]=true;
					que.add(new int[] {rd,cd});
				}
				
			}
		}
		
	}
	private static boolean isIn(int row,int col) {
		return 0<=row&&row<N&&0<=col&&col<M?true:false;
	}

}
