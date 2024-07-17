import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, A, B;
    static int[] dist;
    static ArrayList<Node> node[];
    static final int INF = 1000000001;

    static class Node implements Comparable<Node>{
        @Override
        public int compareTo(Node o) {
            return o.weight - this.weight;
        }

        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        Arrays.fill(dist, -1);
        node = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            node[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            node[from].add(new Node(to, weight));
            node[to].add(new Node(from, weight));
        }
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        dijkstra();

        System.out.println(dist[B]);
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(A, INF));
        dist[A] = INF;
        while (!pq.isEmpty()) {
            int from = pq.peek().to;
            int weight = pq.peek().weight;
            pq.poll();
            if (dist[from] > weight) continue;

            for (int i = 0; i < node[from].size(); i++) {
                int to = node[from].get(i).to;
                int weightTo = Math.min(weight, node[from].get(i).weight);
                if (weightTo > dist[to]) {
                    dist[to] = weightTo;
                    pq.offer(new Node(to, weightTo));
                }
            }
        }
    }
}
