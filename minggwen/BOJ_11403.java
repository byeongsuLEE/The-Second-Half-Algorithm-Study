import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11403 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int [N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		while(true) {
			boolean flag = false;
			for(int i=0;i<N;i++) {
				for(int k=0;k<N;k++) {
					for(int j=0;j<N;j++) {
						if(map[i][k]==1&&map[k][j]==1&&map[i][j]==0) {
							map[i][j]=1;
							flag=true;
						}
					}
				}
			}
			if(!flag)break;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}

	}

}
