import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15724 {

    private static class PartialSum {
        int[][] partialSum;
        public PartialSum(int[][] map) {
            partialSum = new int[map.length][map[0].length];
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (i == 0 && j == 0) {
                        partialSum[i][j] = map[i][j];
                    }
                    else if (i == 0) {
                        partialSum[i][j] = map[i][j] + partialSum[i][j - 1];
                    }
                    else if (j == 0) {
                        partialSum[i][j] = map[i][j] + partialSum[i - 1][j];
                    }
                    else {
                        partialSum[i][j] = map[i][j] + partialSum[i - 1][j] + partialSum[i][j - 1] - partialSum[i - 1][j - 1];
                    }
                }
            }
        }

        public int getSum(int y1, int x1, int y2, int x2) {
            y1 = y1 - 1;
            x1 = x1 - 1;
            y2 = y2 - 1;
            x2 = x2 - 1;
            int total = partialSum[y2][x2];
            int extra1 = (y1 > 0) ? partialSum[y1 - 1][x2] : 0;
            int extra2 = (x1 > 0) ? partialSum[y2][x1 - 1] : 0;
            int extra3 = (y1 > 0 && x1 > 0) ? partialSum[y1 - 1][x1 - 1] : 0;

            return total - extra1 - extra2 + extra3;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int K = Integer.parseInt(br.readLine());
        PartialSum ps = new PartialSum(map);
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(ps.getSum(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
