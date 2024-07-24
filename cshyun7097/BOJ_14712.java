import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14712 {
    static int N, M;
    static boolean[][] visited;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        res = 0;

        visited = new boolean[N][M];
        dfs(0, 0);

        System.out.println(res);
    }

    private static void dfs(int depth, int start) {
        res += check(depth) ? 1 : 0;
        for (int i = start; i < N*M; i++) {
            int x = i / M;
            int y = i % M;
            if (visited[x][y]) continue;
            visited[x][y] = true;
            dfs(depth + 1, i + 1);
            visited[x][y] = false;
        }
    }

    private static boolean check(int depth) {
        if (depth < 4) return true;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++) {
                if (visited[i][j] && visited[i][j+1] && visited[i+1][j] && visited[i+1][j+1]) return false;
            }
        }
        return true;
    }
}
