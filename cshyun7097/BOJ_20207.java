import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20207 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[366];
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int i = start; i <= end; i++) {
                cnt[i]++;
            }
        }

        int sum = 0;
        int max = 0;
        int width = 0;
        for (int i = 0; i < 366; i++) {
            if (cnt[i] == 0) {
                sum += max * width;
                max = width = 0;
                continue;
            }
            width++;
            max = Math.max(max, cnt[i]);
        }
        sum += max * width;
        System.out.println(sum);
    }
}
