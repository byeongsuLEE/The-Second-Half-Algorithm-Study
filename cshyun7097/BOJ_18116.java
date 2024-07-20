import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18116 {
    static int N;
    static int[] parents = new int[(int) Math.pow(10, 6) + 1];
    static int[] counts = new int[(int) Math.pow(10, 6) + 1];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            counts[i] = 1;
        }

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A, B;
            st.nextToken();
            if (st.countTokens() == 2) {
                A = Integer.parseInt(st.nextToken());
                B = Integer.parseInt(st.nextToken());
                setRobot(A, B);
            } else {
                A = Integer.parseInt(st.nextToken());
                question(A);
            }
        }
        System.out.println(sb);
    }

    private static void question(int a) {
        a = find(a);
        sb.append(counts[a]).append("\n");
    }

    private static int find(int a) {
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    private static void setRobot(int a, int b) {
        union(a, b);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        counts[a] += counts[b];
        parents[parents[b]] = a;
    }

}
