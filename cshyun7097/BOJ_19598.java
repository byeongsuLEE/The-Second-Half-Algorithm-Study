import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_19598 {
    static int N;
    static PriorityQueue<Time> pq;

    static class Time implements Comparable<Time> {
        int time;
        boolean isStart;

        public Time(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Time o) {
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new Time(Integer.parseInt(st.nextToken()), true)); // 시작시간
            pq.add(new Time(Integer.parseInt(st.nextToken()), false)); // 종료시간
        }

        int cnt = 0;
        int ans = 0;

        while (!pq.isEmpty()) {
            Time cur = pq.poll();

            if (cur.isStart) {
                cnt++;
                ans = Math.max(cnt, ans);
            } else {
                cnt--;
            }
        }

        System.out.println(ans);
    }


}
