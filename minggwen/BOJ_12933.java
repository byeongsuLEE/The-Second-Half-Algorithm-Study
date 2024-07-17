import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BOJ_12933 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] sounds = str.toCharArray();
		char[] duck = {'q','u','a','c','k'};
		boolean[] visited = new boolean[str.length()];
		if(sounds[0]!='q'||sounds.length%5!=0) {
			System.out.println(-1);
			System.exit(0);
		}
		int cnt=0;
		String s = "";
		for(int i=0;i<str.length();i++) {
			int k=0;
			boolean flag = false;
			for(int j=i;j<str.length();j++) {
				if(!visited[j]&&sounds[j]==duck[k]) {
					visited[j]=true;
					s+=sounds[j];
					k++;
				}
				if(k==5&&!s.equals("quack")) {
					System.out.println(-1);
					System.exit(0);
				}
				if(s.equals("quack")) {
					if(!flag) {
						flag = true;
						cnt++;
					}
					s="";
					k=0;
				}
			}
		}
		if(!s.equals("")) {
			System.out.println(-1);
		}
		else{
			System.out.println(cnt);
		}
	}

}
