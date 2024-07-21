import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_18116 {

	static int len = 1000000;
	static int parent[], size[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		parent = new int[len+1];
		size = new int[len+1];
		
		 for (int i = 1; i < parent.length; i++) {
			 parent[i]=i;
			 size[i]=1;
		 }
		 
		 int N= Integer.parseInt(br.readLine());
		 for(int n=0;n<N;n++) {
			 st = new StringTokenizer(br.readLine());
			 char c = st.nextToken().charAt(0);
			 if(c=='I') {
				 int a=Integer.parseInt(st.nextToken());
				 int b=Integer.parseInt(st.nextToken());
				 union(a,b);
				 
			 }else if(c=='Q') {
				 int num = Integer.parseInt(st.nextToken());
				 System.out.println(size[find(num)]);
			 }
		 }
	}
	private static int find(int a) {
		if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
	}
	private static void union(int a, int b) {
	    int rootA = find(a);
	    int rootB = find(b);
	    
	    if (rootA != rootB) {
	        if (size[rootA] < size[rootB]) {
	            parent[rootA] = rootB;
	            size[rootB] += size[rootA];
	        } else {
	            parent[rootB] = rootA;
	            size[rootA] += size[rootB];
	        }
	    }
	}


}
