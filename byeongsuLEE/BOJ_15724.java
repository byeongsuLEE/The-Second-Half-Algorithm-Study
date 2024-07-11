package day240711;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15724 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][] dpSum = new int[N+1][M+1];
        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= M ; j++){
                dpSum[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int K = Integer.parseInt(br.readLine());


        // 누적합으로 풀어봅시다.
        // x,y 의 까지의 합은 (x-1, y) + (x,y-1) - (x-1,y-1)합의 값이다.
        // x,y까지의 누적합을 dp에 저장해보자.

        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= M ; j++){
                dpSum[i][j] =  dpSum[i][j]+ dpSum[i-1][j] + dpSum[i][j-1] - dpSum[i-1][j-1];

            }
        }


        for(int i = 0 ; i < K ; i++){
            int HumanSumNum = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());


            // x = r 행  y= c 열
            HumanSumNum=dpSum[x2][y2] - dpSum[x1-1][y2] - dpSum[x2][y1-1]+dpSum[x1-1][y1-1];


            sb.append(HumanSumNum).append("\n");


        }
        System.out.println(sb.toString());
    }
}
