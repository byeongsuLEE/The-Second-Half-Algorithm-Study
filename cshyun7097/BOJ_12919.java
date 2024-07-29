import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_12919 {
    static int K;
    static String S, T;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        K = T.length();
        res = dfs(S, T);
        System.out.println(res);

    }

    public static int dfs(String s, String t) {
        if (s.length() == t.length()) {
            if (s.equals(t)) {
                return 1;
            }
            return 0;
        }
        int ans = 0;
        if (t.charAt(0) == 'B') {
            String substring = t.substring(1);
            StringBuilder sb = new StringBuilder(substring);
            String string = sb.reverse().toString();
            ans += dfs(s, string);
        }

        if (t.charAt(t.length() - 1) == 'A') {
            ans += dfs(s, t.substring(0, t.length() - 1));
        }
        return ans > 0 ? 1 : 0;
    }
}
