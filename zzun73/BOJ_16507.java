import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16507 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[R + 1][C + 1];
        for (int i = 1; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
            }
        }

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int total = (r2 - r1 + 1) * (c2 - c1 + 1);
            sb.append((arr[r2][c2] - arr[r1 - 1][c2] - arr[r2][c1 - 1] + arr[r1 - 1][c1 - 1]) / total).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}