import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_21758 {

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int nums[] = new int[N];
		int sum[] = new int[N];
		int rSum[] = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0;n<N;n++) {
			nums[n] = Integer.parseInt(st.nextToken());
			if(n==0)sum[n]=nums[n];
			else sum[n]=sum[n-1]+nums[n];
		}
		for(int n=N-1;n>=0;n--) {
			if(n==N-1) rSum[n]=nums[n];
			else rSum[n]=rSum[n+1]+nums[n];
		}
		int MAX = 0;
		// 벌 벌 꿀
		int side = sum[N-1]-sum[0];
		for(int n=1;n<N-1;n++) {
			MAX = Math.max(MAX, side-nums[n]+sum[N-1]-sum[n]);
		}
		
		// 꿀 벌 벌
		side = rSum[0]-rSum[N-1];
		for(int n=1; n<N-1;n++) {
			MAX = Math.max(MAX, side-nums[n]+rSum[0]-rSum[n]);
		}
		
		// 벌 꿀 벌
		for(int n=1;n<N-1;n++) {
			MAX = Math.max(MAX, sum[n]-sum[0]+rSum[n]-rSum[N-1]);
		}
		
		System.out.println(MAX);
	}

}
