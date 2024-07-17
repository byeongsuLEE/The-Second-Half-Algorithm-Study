import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        while(N --> 0) {
            char[] str = br.readLine().toCharArray();

            int left = 0;
            int right = str.length-1;

            sb.append(Math.min(calc(left,right,str,true),calc(left,right,str,false)) + "\n");
        }
        System.out.println(sb);
    }
    static int calc(int left, int right, char[] str, boolean flag) {
        int diff = 0;
        while(left <= right){
            if(str[left] == str[right]) {
                left++;
                right--;
            }
            else {
                if(flag) {
                    if (str[left + 1] == str[right]) left++;
                    else if (str[left] == str[right - 1]) right--;
                } else {
                    if (str[left] == str[right - 1]) right--;
                    else if (str[left + 1] == str[right]) left++;
                }
                diff++;
            }

            if(diff > 1) break;
        }
        return diff;
    }
}
