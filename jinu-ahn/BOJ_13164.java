import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] kids = new int[N];
        int[] diff = new int[N-1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            kids[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N-1; i++) {
            diff[i] = kids[i+1] - kids[i];
        }
        Arrays.sort(diff);

        int result = 0;
        for (int i = 0; i < N-K; i++) {
            result += diff[i];
        }

        System.out.println(result);
    }
}
