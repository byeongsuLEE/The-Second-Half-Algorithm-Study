package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5547 {
    private static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static int w,h;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[][] result;
    private static int[] dx = {0,-1,-1,0,1,1};
    private static int[] dy1 = {-1,0,1,1,1,0};
    private static int[] dy2 = {-1,-1,0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        arr = new int[w+2][h+2];
        visited = new boolean[w+2][h+2];
        result = new int[w+2][h+2];

        for(int i = 1; i <= w; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= h; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    visited[i][j] = true;
                }
            }
        }

        bfs(0, 0);

        int answer = 0;
        for(int i = 0; i < w+2; i++){
            for(int j = 0; j < h+2; j++){
                answer += result[i][j];
            }
        }
        System.out.println(answer);
    }//main end

    private static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node now = q.poll();
            int nowX = now.x;
            int nowY = now.y;

            for(int d = 0; d < 6; d++){
                int nx = 0;
                int ny = 0;
                if(nowX % 2 == 1){
                    nx = nowX + dx[d];
                    ny = nowY + dy1[d];
                }else{
                    nx = nowX + dx[d];
                    ny = nowY + dy2[d];
                }

                if(!check(nx,ny)){
                    continue;
                }
                if(arr[nx][ny] == 1){
                    result[nx][ny] += 1;
                    continue;
                }

                if(visited[nx][ny]){
                    continue;
                }
                visited[nx][ny] = true;
                q.add(new Node(nx, ny));
            }
        }
    }//bfs end

    private static boolean check(int x, int y){
        return x >= 0 && x < w + 2 && y >= 0 && y < h + 2;
    }//check end
}//class end
