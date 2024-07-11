import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][][] dp = new int[N][M][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, 100_000_000);
            }
        }

        for (int j = 0; j < M; j++) {
            dp[0][j][0] = map[0][j];
            dp[0][j][1] = map[0][j];
            dp[0][j][2] = map[0][j];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j > 0) {
                    dp[i][j][0] = Math.min(dp[i][j][0], dp[i - 1][j - 1][1] + map[i][j]);
                    dp[i][j][0] = Math.min(dp[i][j][0], dp[i - 1][j - 1][2] + map[i][j]);
                }
                if (j < M - 1) {
                    dp[i][j][2] = Math.min(dp[i][j][2], dp[i - 1][j + 1][0] + map[i][j]);
                    dp[i][j][2] = Math.min(dp[i][j][2], dp[i - 1][j + 1][1] + map[i][j]);
                }
                dp[i][j][1] = Math.min(dp[i][j][1], dp[i - 1][j][0] + map[i][j]);
                dp[i][j][1] = Math.min(dp[i][j][1], dp[i - 1][j][2] + map[i][j]);
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < 3; k++) {
                answer = Math.min(answer, dp[N - 1][j][k]);
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();

        br.close();
        bw.close();
    }
}
