import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int nums[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++) {
            nums[n] = Integer.parseInt(st.nextToken());
        }
        long[][] dp = new long[N][21];
        dp[0][nums[0]] = 1;
        for(int n=1;n<N;n++) {
            for(int i=0;i<=20;i++){
                if(dp[n-1][i]!=0){
                    if(0<=i+nums[n]&&i+nums[n]<=20){
                        if(dp[n][i+nums[n]]!=0){
                            dp[n][i+nums[n]]+=dp[n-1][i];
                        }else{
                            dp[n][i+nums[n]]=dp[n-1][i];
                        }

                    }
                    if(0<=i-nums[n]&&i-nums[n]<=20){
                        if(dp[n][i-nums[n]]!=0){
                            dp[n][i-nums[n]]+=dp[n-1][i];
                        }else{
                            dp[n][i-nums[n]]=dp[n-1][i];
                        }
                    }
                }
            }
        }
        System.out.println(dp[N-2][nums[N-1]]);
    }
}
