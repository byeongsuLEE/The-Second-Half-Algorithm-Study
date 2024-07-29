import java.io.*;
import java.util.*;

public class BOJ_2615 {
    static int[][] map = new int[19][19];
    static int[] dx = { 0, 1, 1, -1 };
    static int[] dy = { 1, 0, 1, 1 };
    static boolean[][][] visited = new boolean[19][19][4];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1 || map[i][j] == 2)
                    queue.add(new int[] { i, j });
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!isIn(nx, ny)) continue;
                if (!visited[x][y][i] && countFive(x, y, i, map[x][y])) {
                    if (!isIn(x - dx[i], y - dy[i]) || map[x - dx[i]][y - dy[i]] != map[x][y]) {
                        System.out.println(map[x][y]);
                        System.out.print((x+1) + " " + (y+1));
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    private static boolean countFive(int x, int y, int dir, int color) {
        if(color == 0) return false;
        int cnt = 0;
        while (isIn(x, y) && map[x][y] == color) {
            cnt++;
            visited[x][y][dir] = true;
            x += dx[dir];
            y += dy[dir];
        }
        return cnt == 5;
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < 19 && y < 19;
    }
}
