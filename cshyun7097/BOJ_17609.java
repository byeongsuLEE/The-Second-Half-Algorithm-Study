import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String tmp = br.readLine();
            StringBuilder reverseTmp = new StringBuilder(tmp);
            String res = "2";

            if (tmp.equals(reverseTmp.reverse().toString())) {
                res = "0";
            } else {
                int left = 0;
                int right = tmp.length() - 1;
                while (left < right) {
                    if (tmp.charAt(left) != tmp.charAt(right)) {
                        StringBuilder leftDel = new StringBuilder(tmp).deleteCharAt(left);
                        StringBuilder rightDel = new StringBuilder(tmp).deleteCharAt(right);

                        if (leftDel.toString().equals(leftDel.reverse().toString()) || rightDel.toString().equals(rightDel.reverse().toString())) {
                            res = "1";
                        }
                        break;
                    }
                    left++;
                    right--;
                }
            }
                sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}
