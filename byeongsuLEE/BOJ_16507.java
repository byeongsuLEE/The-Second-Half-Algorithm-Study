

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // 평균구하는 횟수
        StringBuilder sb = new StringBuilder();

        int [][] bright = new int[R+1][C+1];
        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                bright[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        //해당 좌표까지의 합
        int [][] dpSum = new int [R+1][C+1];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                dpSum[i][j] = dpSum[i-1][j] + dpSum[i][j-1] -dpSum[i-1][j-1] + bright[i][j];
            }
        }



        for(int i = 0 ; i < K ; i++){
            st = new StringTokenizer(br.readLine());
            int startR  =  Integer.parseInt(st.nextToken());
            int startC = Integer.parseInt(st.nextToken());
            int endR  =  Integer.parseInt(st.nextToken());
            int endC  =  Integer.parseInt(st.nextToken());

            int numCount = (endR - startR + 1) * (endC - startC+1);

            int answer =  dpSum[endR][endC] + dpSum[startR-1][startC-1] - dpSum[startR-1][endC] - dpSum[endR][startC-1];
            sb.append(answer/numCount).append("\n");
        }

        System.out.println(sb.toString());



    }
}
