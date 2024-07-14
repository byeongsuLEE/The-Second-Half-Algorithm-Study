import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        DFS(A, B, 0);
        System.out.println(-1);
    }

    private static void DFS(long a, long b, int cnt) {
        if (a == b) {
            System.out.println(cnt + 1);
            System.exit(0);
        }
        if (a > b) {
            return;
        }
        DFS(a * 2, b, cnt + 1);
        DFS((a * 10) + 1, b, cnt + 1);
    }
}
