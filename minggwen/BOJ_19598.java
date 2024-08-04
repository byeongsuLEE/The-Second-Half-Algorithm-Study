import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19598 {
	static class Meeting{
		int start; int end;
		public Meeting(int start,int end) {
			this.start=start;
			this.end=end;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		Queue<Meeting> que = new PriorityQueue<>(new Comparator<Meeting>() {

			@Override
			public int compare(Meeting o1, Meeting o2) {
				if(o1.start==o2.start)return o1.end-o2.end;
				return o1.start-o2.start;
			}
			
		});
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			que.add(new Meeting(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		Queue<Meeting> room = new PriorityQueue<>(new Comparator<Meeting>() {
			@Override
			public int compare(Meeting o1,Meeting o2) {
				if(o1.end==o2.end)return o1.start-o2.start;
				return o1.end-o2.end;
			}
		});
		int cnt = 0;
		while(!que.isEmpty()) {
			Meeting q = que.poll();
			if(room.isEmpty()) {
				room.add(q);
				continue;
			}
			if(room.peek().end>q.start) {
				room.add(q);
			}else {
				room.poll();
				room.add(q);
			}
			cnt = Math.max(cnt, room.size());
		}
		System.out.println(cnt);
	}

}
