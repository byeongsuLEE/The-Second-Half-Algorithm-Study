import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] u, v;
    static long[] minYoungHappiness, maxYoungFatigue;
    static long[] maxOldHappiness, minOldFatigue;

    public static void main(String[] args) throws IOException {
        init();
        int result = solution();
        System.out.println(result);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        u = new long[N];
        v = new long[N];
        minYoungHappiness = new long[N];
        maxYoungFatigue = new long[N];
        maxOldHappiness = new long[N];
        minOldFatigue = new long[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            u[i] = Long.parseLong(st.nextToken());
            v[i] = Long.parseLong(st.nextToken());
        }
    }

    public static int solution() {
        long minHappiness = Long.MAX_VALUE;
        long maxFatigue = Long.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            if (u[i] != 0) {
                minHappiness = Math.min(minHappiness, u[i]);
            }
            if (v[i] != 0) {
                maxFatigue = Math.max(maxFatigue, v[i]);
            }
            minYoungHappiness[i] = minHappiness;
            maxYoungFatigue[i] = maxFatigue;
        }

        long maxHappiness = Long.MIN_VALUE;
        long minFatigue = Long.MAX_VALUE;

        for (int i = N - 1; i >= 0; i--) {
            if (u[i] != 0) {
                maxHappiness = Math.max(maxHappiness, u[i]);
            }
            if (v[i] != 0) {
                minFatigue = Math.min(minFatigue, v[i]);
            }
            maxOldHappiness[i] = maxHappiness;
            minOldFatigue[i] = minFatigue;
        }

        for (int K = N - 2; K >= 0; K--) {
            if (minYoungHappiness[K] > maxOldHappiness[K + 1] && maxYoungFatigue[K] < minOldFatigue[K + 1]) {
                return K + 1;
            }
        }

        return -1;
    }
}
