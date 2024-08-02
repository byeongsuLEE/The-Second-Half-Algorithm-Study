import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T -- > 0) {
            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }
            long sum = 0;
            while(pq.size() != 1) {
                long cur1 = pq.poll();
                long cur2 = pq.poll();
                sum += cur1 + cur2;
                pq.offer(cur1 + cur2);

            }
            System.out.println(sum);
        }
    }
}
