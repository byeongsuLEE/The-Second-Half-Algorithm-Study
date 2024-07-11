import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17485 {

    static int N, M;
    static int[][] map;
    static int[][][] dp;
    static final int[][] delta = {{-1, -1}, {-1, 0}, {-1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N + 1][M];
        dp = new int[N + 1][M][3];

        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        for (int[][] d : dp) {
            for (int[] tmp : d) {
                Arrays.fill(tmp, Integer.MAX_VALUE);
            }
        }

        for (int m = 0; m < M; m++) {
            dp[0][m][0] = dp[0][m][1] = dp[0][m][2] = 0;
        }

        for (int n = 1; n <= N; n++) {
            for (int m = 0; m < M; m++) {
                for (int k = 0; k < 3; k++) {
                    for (int d = 0; d < 3; d++) {
                        if (k == d) continue;  // 같은 방향으로 두 번 연속 이동 불가
                        int rd = n + delta[d][0];
                        int cd = m + delta[d][1];
                        if (isIn(rd, cd)) {
                            dp[n][m][k] = Math.min(dp[n][m][k], dp[rd][cd][d] + map[n][m]);
                        }
                    }
                }
            }
        }

        int MIN = Integer.MAX_VALUE;
        for (int m = 0; m < M; m++) {
            for (int k = 0; k < 3; k++) {
                MIN = Math.min(MIN, dp[N][m][k]);
            }
        }
        System.out.println(MIN);
    }

    private static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}
