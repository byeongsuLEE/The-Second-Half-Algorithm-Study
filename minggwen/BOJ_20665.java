import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20665 {
    static class PersonS implements Comparable<PersonS> {
        int start, end;

        public PersonS(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(PersonS o) {
        	if(this.start==o.start) {
        		int thisD= this.end-this.start;
        		int oD = o.end-o.start;
        		return thisD-oD;
        	}
            return this.start - o.start;
        }
    }

    static class PersonE implements Comparable<PersonE> {
        int start, end, idx;

        public PersonE(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }

        @Override
        public int compareTo(PersonE o) {
            return this.end - o.end;
        }
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        boolean[][] times = new boolean[N + 1][720];
        Queue<PersonS> que = new PriorityQueue<>();
        Queue<PersonE> seat = new PriorityQueue<>();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int start = timeToInt(st.nextToken());
            int end = timeToInt(st.nextToken());
            que.add(new PersonS(start, end));
        }
        while (!que.isEmpty()) {
            int start = que.peek().start;
            int end = que.peek().end;
            que.poll();
            int idx=1;
            if (seat.isEmpty()) {
                seat.add(new PersonE(start, end, idx));
            } else {
                while (!seat.isEmpty() && start >= seat.peek().end) {
                    seat.poll();
                }
                idx = getSeat(seat);
                seat.add(new PersonE(start, end, idx));
            }
            for (int s = start; s < end; s++) {
                times[idx][s] = true;
            }
        }

        int cnt = 0;
        for (int i = 0; i < 720; i++) {
            if (!times[P][i]) cnt++;
        }
        System.out.println(cnt);
    }

    private static int timeToInt(String str) {
        int hour = Integer.parseInt(str.substring(0, 2));
        int minute = Integer.parseInt(str.substring(2, 4));
        return (hour - 9) * 60 + minute;
    }

    private static int getSeat(Queue<PersonE> seat) {
        boolean[] occupied = new boolean[N + 1];
        for (PersonE p : seat) {
            occupied[p.idx] = true;
        }

        int maxDistance = -1;
        int idx = 1;

        for (int i = 1; i <= N; i++) {
            if (!occupied[i]) {
                int leftDistance = Integer.MAX_VALUE;
                int rightDistance = Integer.MAX_VALUE;

                for (int j = i - 1; j > 0; j--) {
                    if (occupied[j]) {
                        leftDistance = i - j;
                        break;
                    }
                }

                for (int j = i + 1; j <= N; j++) {
                    if (occupied[j]) {
                        rightDistance = j - i;
                        break;
                    }
                }

                int minDistance = Math.min(leftDistance, rightDistance);
                if (minDistance > maxDistance) {
                    maxDistance = minDistance;
                    idx = i;
                } else if (minDistance == maxDistance && i < idx) {
                    idx = i;
                }
            }
        }

        return idx;
    }
}
