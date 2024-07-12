package day240711;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17485 {
    private static  int N ;
    private static  int M ;
    public static int [] dr = {1,1,1};
    public static int [] dc = {-1, 0, 1};
    private static long min= Integer.MAX_VALUE;;
    private static boolean[][] visited;
    private static int[][] map;

    public static class Location{
        long sum=0 ;
                int dir=  -1;

        public Location( long sum, int dir) {

            this.sum = sum;
            this.dir = dir;
        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

         map = new int[N+1][M+2];

         for(int i = 1; i <= N; i++){
             st = new StringTokenizer(br.readLine());
             for(int j = 1; j <=M; j++){
                 map[i][j] = Integer.parseInt(st.nextToken());
             }
         }

         //왼쪽오른쪽을 빈칸으로 채우자 1~M까지만 써보자.
        // dp[r][c] = 현재 최소의 연료값
        // -1 = 맨처음   0 = 왼쪽아래  , 1 = 바로아래 , 2= 오른쪽아래
        Location [][] dp = new Location[N+1][M+2];

         for(int i = 0; i <= N; i++){
             for(int j = 0; j <=M+1; j++){
                 dp[i][j] = new Location(Integer.MAX_VALUE,-1);
             }
         }

         for(int j = 1;j <= M ;j++){
             dp[1][j] = new Location(map[1][j],-1);
         }

        // 처음 시도 왼쪽위 , 위 , 오른쪽 위 한칸위에만 봤지만  두 번쨰 칸도 보자
         for(int i = 2; i <=N;i++){
             for(int j = 1; j <=M;j++) {

                 for (int d1 = 0; d1 < 3; d1++) {
                     for (int d2 = 0; d2 < 3; d2++) {
                         if (d1 == d2) continue;
                         if(map[i-1][j+dc[1]]==0 || map[i-2][j+dc[2]]==0) continue;

                         if (dp[i][j].sum > dp[i - 1][j + dc[d1]].sum + dp[i - 2][j + dc[d2]].sum + map[i][j]) {
                             dp[i][j].sum = dp[i - 1][j + dc[d1]].sum + dp[i - 2][j + dc[d2]].sum + map[i][j];

                             dp[i][j].dir = d1;
                         }

                     }

                 }
                 if(min > dp[i][j].sum) min = dp[i][j].sum;
             }

         }
        System.out.println(min);





    }

}
