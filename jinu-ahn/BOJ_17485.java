import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17485 {
    // BFS 메모리 초과
//    static int N,M;
//    static int[] dy = {-1,0,1};
//    static int[][] area;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        area = new int[N][M];
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < M; j++) {
//                area[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < M; i++) {
//            min = Math.min(min,bfs(0,i,area[0][i]));
//
//        }
//        System.out.println(min);
//    }
//
//    static int  bfs(int x, int y, int dist) {
//
//        int min = Integer.MAX_VALUE;
//
//        Queue<int[]> queue = new ArrayDeque<>();
//        queue.offer(new int[]{x,y,dist,-1});
//
//        while(!queue.isEmpty()) {
//            int[] cur = queue.poll();
//            if(cur[0] == N-1) {
//                min = Math.min(min,cur[2]);
//                continue;
//            }
//
//            for (int i = 0; i < 3; i++) {
//                if(cur[3] == i) continue;
//                int nx = cur[0] + 1;
//                int ny = cur[1] + dy[i];
//                if(isIn(nx,ny)){
//                    queue.offer(new int[]{nx,ny,area[nx][ny] + cur[2],i});
//                }
//            }
//        }
//        return min;
//    }
//    static boolean isIn(int x,int y){
//        return x >= 0 && y >= 0 && x < N && y < M;
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] area = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[N][M][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j],Integer.MAX_VALUE);
            }
        }
        for (int j = 0; j < M; j++) {
            dp[0][j][0] = dp[0][j][1] = dp[0][j][2] = area[0][j];
        }

        int[] dy = {-1,0,1};
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if(k==l) continue;
                        if(isIn(j+dy[l],M)) {
                            dp[i][j][k] = Math.min(dp[i-1][j+dy[l]][l] + area[i][j], dp[i][j][k]);
                        }
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                min = Math.min(min,dp[N-1][i][j]);
            }
        }
        System.out.println(min);
    }
    static boolean isIn(int y , int M){
        return y >= 0 && y < M;
    }
}
