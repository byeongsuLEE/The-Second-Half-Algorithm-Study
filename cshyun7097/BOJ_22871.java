import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] visit;
    static Boolean flag;

    static void check(long[] arr, int start, int N, long K) {
        if (start == N - 1) {
            flag = true;
        }
        for (int j = start + 1; j < N; j++) {
            long result = (long) (j - start) * (1 + Math.abs(arr[start] - arr[j]));
            if (result <= K && visit[j] == 0) {
                visit[j] = 1;
                check(arr, j, N, K);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visit = new int[N];
        long left = 0;
        long right = (long) (N - 1) * (1 + Math.abs(arr[N - 1] - arr[0]));
        long mid = 0;
        long ans = 0;
        while (left <= right) {
            for (int i = 0; i < N; i++) {
                visit[i] = 0;
            }
            visit[0] = 1;
            flag = false;
            mid = (left + right) / 2;
            check(arr, 0, N, mid);
            if (flag) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        System.out.println(ans);
    }
}
