import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953 {

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		Queue<Integer> que = new ArrayDeque<>();
		boolean visited[] = new boolean[B+1];
		que.add(A);
		visited[A]=true;
		int cnt=0;
		boolean flag = false;
		while(!que.isEmpty()) {
			cnt++;
			int size = que.size();
			for(int s=0;s<size;s++) {
				int q = que.poll();
				if(q==B) {
					flag = true;
					break;
				}
				if((long)q*2<=B&&!visited[q*2]) {
					que.add(q*2);
					visited[q*2]=true;
				}
				if((long)q*10+1<=B&&!visited[q*10+1]) {
					que.add(q*10+1);
					visited[q*10+1]=true;
				}
			}
			if(flag)break;
		}
		System.out.println(flag?cnt:-1);

	}

}
