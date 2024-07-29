import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N];
        int[] b = new int[N];
        int[] aMinus = new int[N];
        int[] aPlus = new int[N];
        int[] originalMinus = new int[N];
        int[] originalPlus = new int[N];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            aMinus[i] = a[i] - b[i];
            aPlus[i] = a[i] + b[i];

            originalMinus[i] = aMinus[i];
            originalPlus[i] = aPlus[i];
        }

        Arrays.sort(aMinus);
        Arrays.sort(aPlus);

        int left, right, mid;
        for (int i = 0; i < N; ++i) {
            left = 0;
            right = N;
            while (left < right) {
                mid = (left + right) >> 1;
                if (aPlus[mid] < originalMinus[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            sb.append(right + 1).append(" ");

            left = 0;
            right = N;
            while (left < right) {
                mid = (left + right) >> 1;
                if (aMinus[mid] <= originalPlus[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            sb.append(right).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}