import java.io.*;
import java.util.*;

public class BOJ_18352 {
    static class Edge implements Comparable<Edge> {
        int targetId, cost;

        public Edge(int targetId, int cost) {
            this.targetId = targetId;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }

    private static final int INF = 100_000_000;
    static List<Edge>[] list;
    static int N, K, X;
    static int[] dist;

    public static void helper() {
        for (int i = 1; i <= N; i++) {
            dist[i] = INF;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        dist[X] = 0;
        pq.offer(new Edge(X, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.cost > dist[cur.targetId]) {
                continue;
            }

            for (Edge next : list[cur.targetId]) {
                if (dist[next.targetId] > cur.cost + next.cost) {
                    dist[next.targetId] = cur.cost + next.cost;
                    pq.offer(new Edge(next.targetId, dist[next.targetId]));
                }
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(new Edge(B, 1));
        }

        helper();

        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                sb.append(i).append("\n");
            }
        }

        bw.write(sb.length() == 0 ? "-1" : sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}