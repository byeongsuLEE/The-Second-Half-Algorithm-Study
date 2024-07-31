import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int now = 3;
        int preNow = 0;
        int mid = 3;

        while(N > now) {
            preNow = now;
            now = now*2+(mid+1);
            mid++;
        }

        while(true) {
            if(preNow < N && N <= preNow+mid) {
                N -= preNow;
                break;
            }
            if(N <= preNow) {
                now = preNow;
                mid--;
                preNow = (now-mid)/2;
            }
            else {
                now = preNow;
                N -= (preNow+mid);
                mid--;
                preNow = (now-mid)/2;
            }
        }

        if(N==1)System.out.println('m');
        else System.out.println('o');
    }
}
