import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9489 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		while(true) {
			st=new StringTokenizer(br.readLine());
			int N= Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			if(N==0&&K==0)break;
			int data[]=new int[N+1];
			st=new StringTokenizer(br.readLine());
			for(int n=1;n<=N;n++) {
				data[n]=Integer.parseInt(st.nextToken());
			}
			int parent[] = new int[N+1];
			int p=0;
			parent[0]=-1;
			int findIdx = 0;
			for(int n=1;n<=N;n++) {
				if(data[n]==K)findIdx=n;
				if(n>1&&data[n-1]+1!=data[n])p++;
				parent[n]=p;
			}
			int cnt=0;
			for(int n=1;n<=N;n++) {
				if(parent[n]!=parent[findIdx]&&parent[parent[n]]==parent[parent[findIdx]])cnt++;
			}
			System.out.println(cnt);
		}
		
	}

}
