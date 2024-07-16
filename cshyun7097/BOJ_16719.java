import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16719 {
    static StringBuffer sb = new StringBuffer();
    static boolean[] visited;
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        visited  = new boolean[str.length()];

        sol(0, str.length() - 1);
        System.out.println(sb);
    }

    private static void sol(int left, int right) {
        if (left > right) return;
        int idx = left;

        for (int i = left; i <= right; i++) {
            if (str.charAt(idx) > str.charAt(i)) {
                idx = i;
            }
        }
        visited[idx] = true;

        for (int i = 0; i < str.length(); i++) {
            if (visited[i]) {
                sb.append(str.charAt(i));
            }
        }
        sb.append("\n");

        sol(idx + 1, right);
        sol(left, idx - 1);
    }
}
