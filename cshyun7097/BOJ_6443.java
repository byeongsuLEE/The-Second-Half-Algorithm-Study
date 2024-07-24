import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;

public class BOJ_6443 {
    static int N;
    static int[] visited;
    static Stack<Character> stack = new Stack<>();
    static PriorityQueue<String> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            int length = chars.length;
            visited = new int[26];
            for (char now : chars) {
                visited[now - 'a']++;
            }
            dfs(chars, length);
            while(!pq.isEmpty()) {
                sb.append(pq.poll()).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void dfs(char[] chars, int endPoint) {
        if (endPoint == stack.size()) {
            StringBuilder sb = new StringBuilder();
            for (Character s : stack) {
                sb.append(s);
            }
            pq.add(sb.toString());
        }

        for (int i = 0; i < 26; i++) {
            if (visited[i] > 0) {
                visited[i]--;
                stack.push((char) (i + 'a'));
                dfs(chars, endPoint);
                stack.pop();
                visited[i]++;
            }
        }
    }
}
