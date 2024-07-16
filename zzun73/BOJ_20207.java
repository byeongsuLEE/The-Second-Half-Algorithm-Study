import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] count = new int[367];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            for (int j = S; j <= E; j++) {
                count[j]++;
            }
        }

        int answer = 0;
        int width = 0;
        int height = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0) {
                answer += width * height;
                width = height = 0;
                continue;
            }

            width++;
            height = Math.max(height, count[i]);
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}