import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1939 {

    private static class Bridge implements Comparable<Bridge> {

        int start;
        int end;
        long cost;

        public Bridge(int start, int end, long cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
        public int compareTo(Bridge b) {
            return -Long.compare(this.cost, b.cost);
        }

        @Override
        public String toString() {
            return "Bridge{" +
                    "start=" + start +
                    ", end=" + end +
                    ", cost=" + cost +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Bridge> pq = new PriorityQueue<Bridge>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            pq.add(new Bridge(start, end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int factory1 = Integer.parseInt(st.nextToken());
        int factory2 = Integer.parseInt(st.nextToken());

        int[] parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        while (!pq.isEmpty()) {
            Bridge b = pq.poll();
            //System.out.println(b);
            union(parents, b.start, b.end);
            if (findParent(parents, factory1) == findParent(parents, factory2)) {
                System.out.println(b.cost);
                break;
            }

        }


    }

    private static void union(int[] parents, int i1, int i2) {
        i1 = findParent(parents, i1);
        i2 = findParent(parents, i2);
        if (i1 != i2) {
            parents[i1] = i2;
        }
    }

    private static int findParent(int[] parents, int i) {
        if (parents[i] == i) return i;
        return parents[i] = findParent(parents, parents[i]);
    }
}
