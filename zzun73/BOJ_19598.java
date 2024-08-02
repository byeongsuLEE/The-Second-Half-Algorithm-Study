import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_19598 {
    static int n;

    static class Room implements Comparable<Room> {
        int s, e;

        public Room(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Room o) {
            if (this.s == o.s) return this.e - o.e;
            return this.s - o.s;
        }
    }

    static Room arr[];
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        arr = new Room[n];
        pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i] = new Room(start, end);
        }
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            Room cur = arr[i];
            if (pq.isEmpty()) {
                pq.offer(cur.e);
                continue;
            }

            int end = pq.poll();
            if (cur.s < end) {
                pq.offer(end);
            }
            pq.offer(cur.e);
        }
        bw.write(String.valueOf(pq.size()));

        br.close();
        bw.close();
    }
}