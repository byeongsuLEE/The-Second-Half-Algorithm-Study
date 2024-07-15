package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20207 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[366];


        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            for(int j = s; j <= e; j++) {
                arr[j]++;
            }
        }

        int count = 0;
        int max = 0;
        int sum = 0;

        for(int i = 0; i <= 365; i++) {
            if(arr[i] == 0){
                sum += max * count;
                max = 0;
                count = 0;
                continue;
            }
            count++;
            max = Math.max(max, arr[i]);
        }

        sum += max * count;
        System.out.println(sum);
    }//main end
}//class end
