import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[N - 1][21];
        dp[0][arr[0]] = 1;

        for (int i = 1; i < N - 1; i++) {
            for (int num = 0; num <= 20; num++) {
                if (dp[i - 1][num] != 0) {
                    int plus = num + arr[i];
                    int minus = num - arr[i];

                    if (plus >= 0 && plus <= 20) {
                        dp[i][plus] += dp[i - 1][num];
                    }
                    if (minus >= 0 && minus <= 20) {
                        dp[i][minus] += dp[i - 1][num];
                    }
                }
            }
        }

        bw.write(String.valueOf(dp[N - 2][arr[N - 1]]));

        br.close();
        bw.close();
    }
}