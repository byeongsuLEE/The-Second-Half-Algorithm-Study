package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16507 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int wid,hei,que,sum;
        int r1,c1,r2,c2;

        int[][] arr;

        StringTokenizer st = new StringTokenizer(br.readLine());

        wid = Integer.parseInt(st.nextToken());
        hei = Integer.parseInt(st.nextToken());
        que = Integer.parseInt(st.nextToken());

        arr = new int[wid+1][hei+1];

        for(int i = 1; i <= wid; i++) {
            st = new StringTokenizer(br.readLine());

            sum = 0;

            for(int j = 1; j <= hei; j++) {
                sum += Integer.parseInt(st.nextToken());
                arr[i][j] = sum + arr[i-1][j];
            }
        }

        for(int x = 0; x < que; x++) {
            st = new StringTokenizer(br.readLine());

            r1 = Integer.parseInt(st.nextToken());
            c1 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            c2 = Integer.parseInt(st.nextToken());

            sb.append((arr[r2][c2] - arr[r1 - 1][c2] - arr[r2][c1 - 1] + arr[r1 - 1][c1 - 1])/((r2 - r1 + 1) * (c2 - c1 + 1))).append("\n");
        }

        System.out.println(sb);
    }//main end
}//class end
