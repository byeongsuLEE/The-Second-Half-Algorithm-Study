import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14712 {
    static int N, M, answer;
    static boolean[][] visited;

    static void helper(int x, int y) {
        if (y >= M) {
            x += 1;
            y = 0;
        }

        if (x >= N) {
            answer++;
            return;
        }

        helper(x, y + 1);

        if (x > 0 && y > 0 && visited[x - 1][y] && visited[x][y - 1] && visited[x - 1][y - 1]) {
            return;
        }

        visited[x][y] = true;
        helper(x, y + 1);
        visited[x][y] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];

        helper(0, 0);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}