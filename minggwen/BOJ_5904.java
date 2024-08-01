import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5904 {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		int len = 3;
		int idx = 3;
		while(N>len) {
			len = len*2+ ++idx;
		}
		while(true) {
			int mid = (len-idx)/2;
			if(N<=mid) {
				idx--;
				len = mid;				
			}else if(N<=mid+idx) {
				if(mid+1==N) {
					System.out.println('m');
				}else {
					System.out.println('o');
				}
				break;
			}else {
				N-= mid+idx;
				idx--;
				len = mid;
			}
		}

	}
}
