import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[][] photo = new int[R+1][C+1];
        for(int i =  1 ; i <=R ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j<=C ; j++){
                int light = Integer.parseInt(st.nextToken());
                photo[i][j] = light+photo[i][j-1]+photo[i-1][j]-photo[i-1][j-1];
            }
        }

        for(int i = 0 ;i <Q ; i++){
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int num = (r2-r1+1)*(c2-c1+1);
            System.out.println((photo[r2][c2]-photo[r2][c1-1]-photo[r1-1][c2]+photo[r1-1][c1-1])/num);


        }

    }

}
