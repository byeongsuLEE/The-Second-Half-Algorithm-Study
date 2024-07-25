import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
	static class top{
		int height;
		int index;
		public top(int height, int index) {
			this.height = height;
			this.index = index;
		}
	
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<top> stack = new Stack<>();
		top[] tops = new top[N+1];
		for(int i = 1 ; i<=N ; i++) {
			int height = Integer.parseInt(st.nextToken());
			tops[i] = new top(height,i);
			}
		int[] answer = new int[N+1];

		for(int i = N ; i>0 ; i--) {
			while(!stack.isEmpty() && tops[i].height>stack.peek().height) {
				top cur = stack.pop();
				answer[cur.index] = i;
			}
			stack.push(tops[i]);
			
		}
		for(int i = 1 ; i<=N ; i++) {
			System.out.print(answer[i]+" ");
		}
		
		
	}
}
