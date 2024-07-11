import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17485 {
    static int N,M;
    static int[][] map;
    static int[] dc = {-1,0,1};
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = 1000001;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                dp[0][i][j] = map[0][i];
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(j==0){
                    dp[i][j][1] = dp[i-1][j+1][2]+map[i][j];
                    dp[i][j][0] = Math.min(dp[i-1][j][1],dp[i-1][j+1][2])+map[i][j];
                }else if(j==M-1){
                    dp[i][j][1] = dp[i-1][j-1][0]+map[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j-1][0],dp[i-1][j][1])+map[i][j];
                }else {
                    dp[i][j][0] = Math.min(dp[i-1][j][1],dp[i-1][j+1][2])+map[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j-1][0],dp[i-1][j+1][2])+map[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j-1][0],dp[i-1][j][1])+map[i][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                min = Math.min(min,dp[N-1][i][j]);
            }

        }
        System.out.println(min);

    }

}
