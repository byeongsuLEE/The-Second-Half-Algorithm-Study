import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2812 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] num = new int[N];
		String str = br.readLine();
		for(int n=0;n<N;n++) {
			num[n] = str.charAt(n)-'0';
		}
		Stack<Integer> s = new Stack<>(); 
		for(int i=0;i<N;i++) {
			int c = num[i];
			while(!s.isEmpty()&&s.peek()<c&&K>0) {
				K--;
				s.pop();
			}
			s.push(c);
		}
		while(K>0) {
			s.pop();
			K--;
		}
		StringBuilder result = new StringBuilder();
		for(int c:s) {
			result.append(c);
		}
		System.out.println(result);

	}

}
