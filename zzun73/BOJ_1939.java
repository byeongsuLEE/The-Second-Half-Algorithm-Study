import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge> {
        int start, target, weight;

        public Edge(int start, int target, int weight) {
            this.start = start;
            this.target = target;
            this.weight = weight;
        }

        public int compareTo(Edge o) {
            return o.weight - this.weight;
        }
    }

    static int N;
    static int[] root;
    static PriorityQueue<Edge> pq;

    static void init() {
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }
    }

    static int find(int x) {
        if (root[x] == x) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa <= pb) {
            root[pb] = pa;
        } else {
            root[pa] = pb;
        }
    }

    static int helper(int S, int E) {
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (edge.start != edge.target) {
                union(edge.start, edge.target);
            }

            if (find(S) == find(E)) {
                return edge.weight;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();
        root = new int[N + 1];
        init();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            pq.add(new Edge(A, B, C));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(helper(S, E)));

        br.close();
        bw.close();
    }
}