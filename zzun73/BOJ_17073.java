import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static class Node {
        int index;

        public Node() {
        }

        public Node(int index) {
            this.index = index;
        }
    }

    static ArrayList<ArrayList<Node>> tree = new ArrayList<ArrayList<>>();
    static long[] water;
    static Node root;

    public static void BOJ_17073(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        water = new long[N];
        water[1] = W;
        root = new Node();

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            tree.get(U).add(new Node(V));
            tree.get(V).add(new Node(U));
        }

        int leafNodeCount = 0;
        for (int i = 2; i <= N; i++) {
            if (tree.get(i).size() == 1) leafNodeCount += 1;
        }

        bw.write(String.valueOf((double) W / leafNodeCount));
        br.close();
        bw.close();
    }
}