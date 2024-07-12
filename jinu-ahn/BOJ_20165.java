import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20165 {
    static int[][] domino;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int N,M,R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        domino = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                domino[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            int d = 0;
            if(dir.equals("E")) d = 2;
            else if (dir.equals("W")) d = 3;
            else if (dir.equals("N")) d = 1;
            if(!visited[x][y])
                result += bfs(x,y,d);
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            visited[x][y] = false;
        }

        System.out.println(result);
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <=M ; j++) {
                System.out.print(!visited[i][j] ? "S " : "F ");
            }
            System.out.println();
        }

    }
    static int bfs(int x, int y, int dir) {
        int atkCount = 0;
        if(!visited[x][y]) atkCount++;
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{x,y,domino[x][y],dir});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int nx = cur[0] + dx[cur[3]];
            int ny = cur[1] + dy[cur[3]];

            if(isIn(nx,ny) &&  cur[2] != 1){
                if(visited[nx][ny]) {
                    queue.offer(new int[]{nx,ny,cur[2]-1,dir});
                    continue;
                }
                visited[nx][ny] = true;
                if(cur[2] > domino[nx][ny]) {
                    queue.offer(new int[]{nx,ny,cur[2]-1,dir});
                    atkCount++;
                } else {
                    queue.offer(new int[]{nx,ny,domino[nx][ny],dir});
                    atkCount++;
                }
            }
        }
        return atkCount;
    }

    static boolean isIn(int x, int y) {
        return x >= 1 && y >= 1 && x <= N && y <= M;
    }
}
