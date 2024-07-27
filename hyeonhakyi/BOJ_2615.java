package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2615 {
    static int[][] arr = new int[21][21];
    static int[][][] map = new int[21][21][4];
    static int[] dx = {1,1,0,-1};
    static int[] dy = {0,1,1,1};

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 1; i <= 19; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 19; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(val());
    }//main end

    private static String val(){
        for(int j = 1; j <= 19; j++){
            for(int i = 1; i <= 19; i++){
                if(arr[i][j] != 0){
                    for(int d = 0; d < 4; d++){
                        if(map[i][j][d] == 0 && check(i,j,d,arr[i][j]) == 5){
                            return arr[i][j] + "\n" + i + "\n" + j + "\n";
                        }
                    }
                }
            }
        }
        return "0";
    }

    private static int check(int x, int y, int d, int color){
        int nx = x + dx[d];
        int ny = y + dy[d];

        if(arr[nx][ny] == color){
            return map[nx][ny][d] = check(nx,ny,d,color) + 1;
        }
        return 1;
    }
}//class end
