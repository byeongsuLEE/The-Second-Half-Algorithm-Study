import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13975 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int N= Integer.parseInt(br.readLine());
			Queue<Long> que = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			for(int n=0;n<N;n++) {
				que.add(Long.parseLong(st.nextToken()));
			} 
			Long sum=0L;
			while(!que.isEmpty()) {
				if(que.size()==1) {
					break;
				}
				Long num = que.poll()+que.poll();
				sum+=num;
				que.add(num);
						
			}
			System.out.println(sum);
		}

	}

}
