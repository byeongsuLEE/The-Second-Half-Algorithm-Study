import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549 {
	static int N,K;
	static int dp[] = new int[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Arrays.fill(dp, 100000000);
		dp[N] = 0;
		Queue<Integer> que= new ArrayDeque<>();
		que.add(N);
		while(!que.isEmpty()) {
			int num = que.poll();
			if(isIn(num*2)&&dp[num*2]>dp[num]) {
				dp[num*2]=dp[num];
				que.add(num*2);
			}
			if(isIn(num+1)&&dp[num+1]>dp[num]+1) {
				dp[num+1] = dp[num]+1;
				que.add(num+1);
			}
			if(isIn(num-1)&&dp[num-1]>dp[num]+1) {
				dp[num-1] = dp[num]+1;
				que.add(num-1);
			}
		}
		System.out.println(dp[K]);
	}
	private static boolean isIn(int num) {
		return 0<=num&&num<=100000?true:false;
	}
}
