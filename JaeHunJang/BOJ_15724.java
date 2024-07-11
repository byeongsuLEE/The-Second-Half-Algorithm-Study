import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 주지수 / 20분
public class BOJ_15724 {
    static int N, M, map[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) + map[i-1][j] + map[i][j-1] - map[i-1][j-1];
            }
        }

        int K = Integer.parseInt(br.readLine());
        int sr, sc, er, ec;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            sr = Integer.parseInt(st.nextToken());
            sc = Integer.parseInt(st.nextToken());
            er = Integer.parseInt(st.nextToken());
            ec = Integer.parseInt(st.nextToken());
            System.out.println(map[er][ec] - map[er][sc-1] - map[sr-1][ec] + map[sr-1][sc-1]);
        }

    }
}