import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long[] stones = new long[n];
        long[] dp = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            stones[i] = Long.parseLong(st.nextToken());
        }

        dp[0] = 0; 
        for (int i = 1; i < n; i++) {
            dp[i] = Long.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                dp[i] = Math.min(dp[i], Math.max(dp[j], (long)(i - j) * (1 + Math.abs(stones[i] - stones[j])) ));
            }
        }

        System.out.println(dp[n - 1]);
    }
}
