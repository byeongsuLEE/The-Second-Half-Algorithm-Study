import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15724 {

    private static int N, M, K;
    private static int[][] map;
    private static Range[] ranges;

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < K; ++i) {
            Range range = ranges[i];
            System.out.println(map[range.endX][range.endY] - map[range.endX][range.startY - 1] - map[range.startX - 1][range.endY] + map[range.startX - 1][range.startY - 1]);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken()) + map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1];
            }
        }

        K = Integer.parseInt(br.readLine());

        ranges = new Range[K];
        for (int i = 0; i < K; ++i) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            ranges[i] = new Range(x1, y1, x2, y2);
        }
    }

    private static class Range {

        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Range(int startX, int startY, int endX, int endY) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }

        public int getStartX() {
            return startX;
        }

        public int getStartY() {
            return startY;
        }

        public int getEndX() {
            return endX;
        }

        public int getEndY() {
            return endY;
        }
    }
}