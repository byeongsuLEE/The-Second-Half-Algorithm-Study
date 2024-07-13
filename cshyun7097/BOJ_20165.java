import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20165 {
    static int N, M, R, cnt;
    static int dx[] = { 0, 0, 1, -1 };//오 왼 하 상
    static int dy[] = { 1, -1, 0, 0 };
    static int map[][];
    static char state[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        state = new char[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                state[i][j] = 'S';
            }
        }
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = checkDir(st.nextToken().charAt(0));
            attack(x, y, d);
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            defense(x,y);
        }
        System.out.println(cnt);
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(state[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int checkDir(char tmp) {
        if (tmp == 'E') {//오
            return 0;
        } else if (tmp == 'W') {//왼
            return 1;
        } else if (tmp == 'S') {//하
            return 2;
        } else if (tmp == 'N') {//상
            return 3;
        }
        return 0;
    }

    static void attack(int x, int y, int d) {
        if (state[x][y] == 'F') {
            return;
        } else {
            int size = map[x][y] - 1;
            state[x][y] = 'F';
            cnt++;
            while (size > 0) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    return;
                }
                if (state[nx][ny] == 'F') {
                    size--;
                    x = nx;
                    y = ny;
                    continue;
                }
                size--;
                state[nx][ny] = 'F';
                int newSize = map[nx][ny] - 1;
                x = nx;
                y = ny;
                cnt++;
                size = Math.max(newSize, size);
            }
        }
    }
    static void defense(int x, int y) {
        if(state[x][y]=='F') {
            state[x][y] = 'S';
        }else {
            return;
        }
    }
}
