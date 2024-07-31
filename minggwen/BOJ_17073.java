import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17073 {
	static int N=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		List<List<Integer>> arr = new ArrayList<>();
		for(int n=0;n<=N;n++) {
			arr.add(new ArrayList<>());
		}
		for(int n=0;n<N-1;n++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr.get(u).add(v);
			arr.get(v).add(u);
		}
		int cnt=0;
		for(int i=2;i<=N;i++) {
			if(arr.get(i).size()==1)cnt++;
		}
		System.out.println(String.format("%.10f", (double)W/cnt));

	}

}
