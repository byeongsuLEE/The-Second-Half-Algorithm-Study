package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int count = 1;
        while(m != n){
            if(m < n){
                System.out.println(-1);
                System.exit(0);
            }

            if(m%10 == 1){
                m /= 10;
            }else if(m%2 == 0){
                m /= 2;
            }else{
                System.out.println(-1);
                System.exit(0);
            }
            count++;
        }
        System.out.println(count);
    }//main end
}//class end
