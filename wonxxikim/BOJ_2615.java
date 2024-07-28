import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class Main {
    static int[][] delta = {{1,1},{1,0},{0,1},{1,-1}};
    static int[][] map;
    static boolean[][][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[20][20];
        visit = new boolean[20][20][4];
        for(int i = 1 ;i<=19 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j<=19 ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        int r = 0;
        int c = 0;
        boolean flag = false;
        for(int i = 1; i<=19; i++){
            if(flag) break;
            for(int j = 1 ; j<=19 ;j++){
                if(flag) break;
                if(map[i][j]==0) continue;
                for(int d = 0 ; d<4 ; d++){
                    if(!visit[i][j][d] && check(i,j,d)){
                        answer = map[i][j];
                        if(d==3){
                            r = i+4;
                            c = j-4;
                        }else {
                            r = i;
                            c = j;
                        }
                        flag = true;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
        if(answer!=0) System.out.println(r+" "+c);

    }
    static boolean check(int row, int col , int direc){
        int cnt = 1 ;
        visit[row][col][direc] = true;
        int color = map[row][col];
        while(true){
            int nr = row+delta[direc][0]*cnt;
            int nc = col+delta[direc][1]*cnt;
            if(nc>0&& nr>0 && nr<=19 && nc<=19 && map[nr][nc]==color) {
                cnt++;
                visit[nr][nc][direc] = true;
            }
            else break;
        }
        if(cnt==5) return true;
        else return false;
    }

}
