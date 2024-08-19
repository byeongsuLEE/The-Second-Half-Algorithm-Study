package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int total = Integer.parseInt(st.nextToken());

        long answer = 0;

        long[][] dp = new long[n+1][21];
        dp[1][arr[1]] = 1;

        for(int i = 1; i < n-1; i++){
            for(int j = 0; j < 21; j++){
                if(dp[i][j] != 0){
                    int plus = j + arr[i+1];
                    int minus = j - arr[i+1];

                    if(plus >= 0 && plus < 21){
                        dp[i+1][plus] += dp[i][j];
                    }

                    if(minus >= 0 && minus < 21){
                        dp[i+1][minus] += dp[i][j];
                    }
                }
            }
        }
        answer = dp[n-1][total];
        System.out.println(answer);
    }//main end
}//class end
