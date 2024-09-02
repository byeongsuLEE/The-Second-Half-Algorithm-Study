
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int[][] array;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		array = new int[N][N];
		for (int i = 0; i < N; i++) {
			String [] str = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				array[i][j] =Integer.parseInt(str[j]); 
			}
		}

		dfs(0, 0, N);
		System.out.println(sb.toString());
	}

	private static void dfs(int r, int c, int cnt) {

		if (check(r, c, cnt)) {
			sb.append(array[r][c]);
			return ;
		}
		// A4 등분으로 나누기
		int half = cnt/2;
		sb.append("(");
		dfs(r,c,half);
		dfs(r,c+half,half);
		dfs(r+half,c,half);
		dfs(r+half,c+half,half);
		
		sb.append(")");
		
		
		// 2사분면

		// 3사분면
		// 4사분면

	}

	private static boolean check(int r, int c, int cnt) {
		if (cnt == 1)
			return true;

		// 1사분면
		for (int i = r; i < r + cnt; i++) {
			for (int j = c; j < c + cnt; j++) {
				if (array[r][c] != array[i][j]) {
					return false;
				}
			}
		}
		return true;

	}

}
