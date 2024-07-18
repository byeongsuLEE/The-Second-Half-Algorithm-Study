import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17609 {

	static char[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			String str = br.readLine();
			arr = str.toCharArray();
			boolean flag = false;
			boolean notDrome = false;
			int left = 0;
			int right = str.length()-1;
			while(left<=right) {
				if(arr[left]==arr[right]) {
					left++;
					right--;
				}else {
					if(flag) {
						notDrome=true;
						break;
					}
					if(canDrome(left+1,right)) {
						flag=true;
						left++;
					}else if(canDrome(left,right-1)) {
						flag=true;
						right--;
					}else {
						notDrome = true;
						break;
					}
				}
			}
			if(notDrome) {
				System.out.println(2);
			}else if(flag) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
		

	}
	private static boolean canDrome(int left, int right) {
		while(left<right) {
			if(arr[left]!=arr[right]) return false;
			left++;
			right--;
		}
		return true;
	}

}
