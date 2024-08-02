import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                long x = Long.parseLong(st.nextToken());
                pq.add(x);
            }
            long answer = 0;
            while(pq.size()!=1){
                long n1 = pq.poll();
                long n2 = pq.poll();
                pq.add(n1+n2);
                answer+=(n1+n2);
            }


            System.out.println(answer);
        }

    }

}
