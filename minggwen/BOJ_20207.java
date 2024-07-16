import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20207 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		int N = Integer.parseInt(br.readLine());
		int[] calc = new int[366];
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			for(int i=s; i<=e;i++) {
				calc[i]++;
			}
		}
		int sum = 0;
		int maxHeight = 0;
		int width = 0;
		for(int i=0;i<=365;i++) {
			if(calc[i]==0) {
				sum+=maxHeight*width;
				maxHeight=width=0;
				continue;
			}
			width++;
			maxHeight = Math.max(maxHeight, calc[i]);
		}
		sum+=maxHeight*width;
		System.out.println(sum);
	}

}
