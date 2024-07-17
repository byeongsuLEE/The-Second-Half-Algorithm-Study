package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22871 {
    static int n;
    static int k;
    static long[] arr;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        dp = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            dp[i] = -1;
        }

        System.out.println(jump(0));
    }//main end

    public static long jump(int count) {
        if(count == n-1){
            return 0;
        }

        if(dp[count] != -1){
            return dp[count];
        }

        dp[count] = Long.MAX_VALUE;

        for(int i = count + 1; i < n; i++) {
            dp[count] = Math.min(dp[count], Math.max(jump(i),(i-count) * (1 + Math.abs(arr[i] - arr[count]))));
        }
        return dp[count];
    }
}//class end
