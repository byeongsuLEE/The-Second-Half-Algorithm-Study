import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
class P {
    int x;
    int y;

    public P(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class BOJ_5547 {
    static int W, H;
    static int[][] map;
    static int[][] result;
    static boolean[][] visited;
    static int[][] odd = { {0, -1}, { -1,  0}, {-1, 1}, {0, 1}, {1,  1}, {1, 0}};
    static int[][] even = { {0, -1}, { -1, -1}, {-1, 0}, {0, 1}, {1, 0}, {1, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new int[W+2][H+2];
        visited = new boolean[W+2][H+2];
        result = new int[W+2][H+2];
        for(int i=1;i<=W;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=H;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    visited[i][j] = true;
                }
            }
        }

        bfd(0,0);

        int answer = 0;
        for(int i=0; i<W+2; i++) {
            for(int j=0;j<H+2;j++) {
                answer += result[i][j];
            }
        }

        System.out.println(answer);
    }

    public static void bfd(int startX, int startY) {
        Queue<P> queue = new ArrayDeque<>();
        queue.add(new P(startX, startY));
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            P temp = queue.poll();
            int x = temp.x;
            int y = temp.y;

            for (int i = 0; i < 6; i++) {
                int nx = 0;
                int ny = 0;
                if (x % 2 == 1) {
                    nx = x + odd[i][0];
                    ny = y + odd[i][1];
                } else {
                    nx = x + even[i][0];
                    ny = y + even[i][1];
                }

                if (nx >= 0 && ny >= 0 && ny < H + 2 && nx < W + 2) {
                    if (map[nx][ny] == 1) {
                        result[x][y] += 1;
                        continue;
                    }
                    if (visited[nx][ny] == true) continue;
                    visited[nx][ny] = true;
                    queue.add(new P(nx, ny));
                }
            }
        }
    }

}
