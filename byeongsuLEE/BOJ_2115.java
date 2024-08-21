package day0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2115 {
    private static int R, C;
    private static char[][] map;
    private static int pictureCount;
    private static boolean[][][] visited; // 0123: 상하좌우 방문 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); // 세로의 길이
        C = Integer.parseInt(st.nextToken()); // 가로의 길이
        map = new char[R][C];
        visited = new boolean[R][C][4]; // 상하좌우 방향별로 방문 체크

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray(); 
        }

        // 각 빈 공간을 탐색하여 그림을 걸 수 있는지 확인
        for (int i = 1; i < R - 1; i++) {
            for (int j = 1; j < C - 1; j++) {
                if (map[i][j] == '.') {
                    isPossibleHangPicture(i, j);
                }
            }
        }

        System.out.println(pictureCount);
    }

    public static void isPossibleHangPicture(int r, int c) {
        // 오른쪽에 그림을 걸 수 있는지 확인
        if (c + 1 < C && map[r][c + 1] == '.') {
            // 위쪽 벽 확인
            if (r - 1 >= 0 && map[r - 1][c] == 'X' && map[r - 1][c + 1] == 'X' && !visited[r][c][0] && !visited[r][c + 1][0]) {
                pictureCount++;
                visited[r][c][0] = true;
                visited[r][c + 1][0] = true;
            }
            // 아래쪽 벽 확인
            if (r + 1 < R && map[r + 1][c] == 'X' && map[r + 1][c + 1] == 'X' && !visited[r][c][1] && !visited[r][c + 1][1]) {
                pictureCount++;
                visited[r][c][1] = true;
                visited[r][c + 1][1] = true;
            }
        }

        // 아래쪽에 그림을 걸 수 있는지 확인
        if (r + 1 < R && map[r + 1][c] == '.') {
            // 왼쪽 벽 확인
            if (c - 1 >= 0 && map[r][c - 1] == 'X' && map[r + 1][c - 1] == 'X' && !visited[r][c][2] && !visited[r + 1][c][2]) {
                pictureCount++;
                visited[r][c][2] = true;
                visited[r + 1][c][2] = true;
            }
            // 오른쪽 벽 확인
            if (c + 1 < C && map[r][c + 1] == 'X' && map[r + 1][c + 1] == 'X' && !visited[r][c][3] && !visited[r + 1][c][3]) {
                pictureCount++;
                visited[r][c][3] = true;
                visited[r + 1][c][3] = true;
            }
        }
    }
}
