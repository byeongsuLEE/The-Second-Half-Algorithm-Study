import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_21314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String mk = br.readLine();

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        boolean flag = false;

        String max = findMax(sb, flag, cnt, mk);
        String min = findMin(sb, flag, cnt, mk);

        System.out.println(max);
        System.out.println(min);
    }

    public static String findMax(StringBuilder sb, boolean flag, int cnt, String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!flag && ch == 'K') sb.append(5);
            if (ch == 'M') {
                cnt++;
                flag = true;
            } else if (flag && ch == 'K') {
                sb.append(5);
                for (int j = 0; j < cnt; j++) {
                    sb.append("0");
                }
                flag = false;
                cnt = 0;
            }
        }
        if (cnt != 0) {
            for (int i = 0; i < cnt; i++) {
                sb.append("1");
            }
        }
        return sb.toString();
    }

    public static String findMin(StringBuilder sb, boolean flag, int cnt, String str) {
        sb.setLength(0);
        flag = false;
        cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!flag && ch == 'K') sb.append(5);
            if (ch == 'M') {
                cnt++;
                flag = true;
            } else if (flag && ch == 'K') {
                sb.append(1);
                for (int j = 0; j < cnt - 1; j++) {
                    sb.append("0");
                }
                sb.append(5);
                flag = false;
                cnt = 0;
            }
        }
        if (cnt != 0) {
            sb.append(1);
            for (int i = 0; i < cnt - 1; i++) {
                sb.append("0");
            }
        }


        return sb.toString();
    }
}
