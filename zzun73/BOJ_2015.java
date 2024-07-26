import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        long answer = 0;
        Map<Integer, Long> map = new HashMap<>();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = arr[i - 1] + val;

            if (arr[i] == K) {
                answer++;
            }

            answer += map.getOrDefault(arr[i] - K, 0L);
            map.put(arr[i], map.getOrDefault(arr[i], 0L) + 1);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}