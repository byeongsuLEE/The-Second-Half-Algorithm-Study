import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2141 {

	static class Point implements Comparable<Point>{
		int x;
		int cnt;
		public Point(int x, int cnt) {
			this.x=x;
			this.cnt=cnt;
		}
		@Override
		public int compareTo(Point o) {
			return this.x-o.x;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		List<Point> arr = new ArrayList<>();
		long sum = 0;
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			arr.add(new Point(x,cnt));
			sum+=cnt;
		}
		Collections.sort(arr);
		int n=0;
		long result = 0;
		for(;n<N;n++) {
			result+=arr.get(n).cnt;
			if((sum+1)/2<=result) break;
		}
		System.out.println(arr.get(n).x);
	}

}
