package baekjoon.silver.Num22781;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        long[] dp = new long[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 100_000_000);
        dp[0] = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                long val = (i - j) * (1 + Math.abs(arr[i] - arr[j]));
                val = Math.max(val, dp[j]);
                dp[i] = Math.min(dp[i], val);
            }
        }
        bw.write(String.valueOf(dp[N - 1]));

        br.close();
        bw.close();
    }
}