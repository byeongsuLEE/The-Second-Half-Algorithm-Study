import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 행복 유치원 / 60분
public class BOJ_13164 {
    static int N, K, heights[];
    static List<ArrayDeque<Integer>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        heights = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        // 키 차이 계산
        int[] diffs = new int[N - 1];
        for (int i = 1; i < N; i++) {
            diffs[i - 1] = heights[i] - heights[i - 1];
        }

        // 차이를 정렬
        Arrays.sort(diffs);

        // 가장 큰 K-1개 차이를 제외한 나머지 차이들의 합 계산
        int totalCost = 0;
        for (int i = 0; i < N - K; i++) {  // N-1개 차이 중 K-1개를 제외하므로 N-K개를 사용
            totalCost += diffs[i];
        }

        System.out.println(totalCost);
    }
}