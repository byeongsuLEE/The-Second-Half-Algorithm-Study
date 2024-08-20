import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] number = new int[N];

        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[N][21];
        dp[0][number[0]] = 1;

        for(int i=1; i<N-1; i++){
            for(int j=0; j<21; j++){
                if(dp[i-1][j]==0) continue;
                int plus = number[i] + j;
                int minus = j - number[i];

                if(plus>=0 && plus<=20){
                    dp[i][plus] += dp[i-1][j];
                }
                if(minus>=0 && minus<=20){
                    dp[i][minus] += dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N-2][number[N-1]]);
        
    }
}
