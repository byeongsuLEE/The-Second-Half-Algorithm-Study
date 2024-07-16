import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22871 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stones = new int[N + 1];
        long[] dp = new long[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i <= N; i++) {
            dp[i] = Long.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                long cost = (long)(i - j) * (1 + Math.abs(stones[i] - stones[j]));
                dp[i] = Math.min(dp[i], Math.max(dp[j], cost));
            }
        }

        System.out.println(dp[N]);
    }
}
