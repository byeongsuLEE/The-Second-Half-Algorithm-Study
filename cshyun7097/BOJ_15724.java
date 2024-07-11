import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][M + 1];
        for (int x = 1; x <= N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 1; y <= M; y++) {
                int input = Integer.parseInt(st.nextToken());
                dp[x][y] = dp[x - 1][y] + dp[x][y - 1] + input - dp[x - 1][y - 1];
            }
        }
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        for (int t = 0; t < K; t++) {

            StringTokenizer location = new StringTokenizer(br.readLine());

            int x1, x2, y1, y2;

            x1 = Integer.parseInt(location.nextToken());
            y1 = Integer.parseInt(location.nextToken());
            x2 = Integer.parseInt(location.nextToken());
            y2 = Integer.parseInt(location.nextToken());
            int res = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}
