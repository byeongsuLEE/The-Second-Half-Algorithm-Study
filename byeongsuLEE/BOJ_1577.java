package day0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1577 {
    static int N, M;
    static int K; // 공사중인 도로의 개수
    static int[][][] blocked; // blocked[i][j][0]: 오른쪽 막힘, blocked[i][j][1]: 아래쪽 막힘
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 가로 크기
        M = Integer.parseInt(st.nextToken()); // 세로 크기

        K = Integer.parseInt(br.readLine());

        // 공사 중인 도로 정보를 저장할 배열 (0: 오른쪽, 1: 아래쪽)
        blocked = new int[N + 1][M + 1][2]; // 0: 오른쪽, 1: 아래쪽
        dp = new long[N + 1][M + 1]; // dp[i][j] = (i, j)까지 오는 경로의 수

        // 공사 중인 도로 정보 입력 처리
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 오른쪽 방향이 막힌 경우
            if (x1 == x2 && Math.abs(y1 - y2) == 1) {
                if (y1 < y2) {
                    blocked[x1][y1][0] = 1; // (x1, y1)에서 오른쪽으로 가는 길 막힘
                } else {
                    blocked[x2][y2][0] = 1; // (x2, y2)에서 오른쪽으로 가는 길 막힘
                }
            }

            // 아래쪽 방향이 막힌 경우
            if (y1 == y2 && Math.abs(x1 - x2) == 1) {
                if (x1 < x2) {
                    blocked[x1][y1][1] = 1; // (x1, y1)에서 아래로 가는 길 막힘
                } else {
                    blocked[x2][y2][1] = 1; // (x2, y2)에서 아래로 가는 길 막힘
                }
            }
        }

        // DP 시작점 설정
        dp[0][0] = 1; // 출발점은 경로가 1개

        // DP로 경로의 수 계산
        for (int x = 0; x <= N; x++) {
            for (int y = 0; y <= M; y++) {
                // 왼쪽에서 오는 경우 (오른쪽으로 이동)
                if (y > 0 && blocked[x][y - 1][0] == 0) {
                    dp[x][y] += dp[x][y - 1];
                }

                // 위에서 오는 경우 (아래로 이동)
                if (x > 0 && blocked[x - 1][y][1] == 0) {
                    dp[x][y] += dp[x - 1][y];
                }
            }
        }

        // 최종 결과 출력
        System.out.println(dp[N][M]);
    }
}
