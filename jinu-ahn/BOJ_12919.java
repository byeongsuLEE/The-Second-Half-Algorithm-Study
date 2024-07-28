import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_12919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        System.out.println(calc(S,T));

    }

    static int calc(String s, String t) {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(t);

        while(!queue.isEmpty()) {
            String cur = queue.poll();

            if(cur.length() == s.length()) {
                if (s.equals(cur)) {
                    return 1;
                }
                continue;
            }

            if(cur.charAt(cur.length()-1) == 'A')
                queue.offer(cur.substring(0, cur.length() - 1));

            if(cur.charAt(0) == 'B')
                queue.offer(new StringBuilder(cur.substring(1)).reverse().toString());

        }
        return 0;
    }
}
