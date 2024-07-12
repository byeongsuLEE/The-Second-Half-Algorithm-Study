import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class TargetArea {
        int r1;
        int r2;
        int c1;
        int c2;

        public TargetArea(int r1, int c1, int r2, int c2) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
        }
    }

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static int N, M, K;
    private static int[][] map;
    private static int[][] prefixSumArr;
    private static List<TargetArea> targetAreas;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        prefixSumArr = new int[N][M + 1];
        targetAreas = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                prefixSumArr[i][j + 1] = prefixSumArr[i][j] + Integer.parseInt(st.nextToken());
            }
        }

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(prefixSumArr[i]));
//        }

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            targetAreas.add(new TargetArea(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

//        for (TargetArea targetArea : targetAreas) {
//            System.out.println(targetArea.r1 + " " + targetArea.c1 + " " + targetArea.r2 + " " + targetArea.c2);
//        }
    }

    private static void solve() {
        for (TargetArea targetArea : targetAreas) {
            int r1 = targetArea.r1, c1 = targetArea.c1;
            int r2 = targetArea.r2, c2 = targetArea.c2;
            int sum = 0;
            for (int i = r1 - 1; i < r2; i++) {
                sum += prefixSumArr[i][c2] - prefixSumArr[i][c1 - 1];
//                System.out.println(prefixSumArr[i][c2] + " " +  prefixSumArr[i][c1-1]);
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb.toString());
        
    }
}
