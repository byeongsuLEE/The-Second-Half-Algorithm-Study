import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int[] dx = new int[]{0, 0, 1, -1};
    private static final int[] dy = new int[]{1, -1, 0, 0};
    static int N, M;
    static int[][] map;
    static char[][] result;

    static void defence(int x, int y) {
        result[x][y] = 'S';
    }

    static int attack(int x, int y, char D) {
        int dir = convertDirection(D);
        int size = map[x][y];
        int nx = x, ny = y;
        int count = 0;

        while (size > 0) {
            if (result[nx][ny] == 'S') {
                size = Math.max(size, map[nx][ny]);
                result[nx][ny] = 'F';
                count++;
            }
            size--;

            nx += dx[dir];
            ny += dy[dir];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                break;
            }
        }
        return count;
    }

    static int convertDirection(char D) {
        switch (D) {
            case 'E':
                return 0;
            case 'W':
                return 1;
            case 'S':
                return 2;
            case 'N':
                return 3;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        result = new char[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (char[] row : result) {
            Arrays.fill(row, 'S');
        }

        int answer = 0;
        while (R-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            char D = st.nextToken().charAt(0);

            st = new StringTokenizer(br.readLine(), " ");
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            answer += attack(x1, y1, D);
            defence(x2, y2);
        }

        sb.append(answer).append("\n");
        for (char[] row : result) {
            for (char val : row) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}