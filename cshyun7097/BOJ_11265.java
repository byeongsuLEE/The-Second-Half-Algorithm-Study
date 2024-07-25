import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class BOJ_11265 {

    static int n, m;
    static List<Node>[] list;
    static int[][] time;

    static class Node implements Comparable<Node> {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        time = new int[n + 1][n + 1];
        list = new ArrayList[n + 1];


        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < s1.length; j++) {
                if (i == j + 1) {
                    continue;
                }
                list[i].add(new Node(j + 1, Integer.parseInt(s1[j])));
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            check(i);
        }

        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int start = Integer.parseInt(s1[0]);
            int end = Integer.parseInt(s1[1]);
            int limit = Integer.parseInt(s1[2]);
            if (time[start][end] <= limit) {
                sb.append("Enjoy other party").append("\n");
            } else {
                sb.append("Stay here").append("\n");
            }
        }

        System.out.println(sb.toString());

    }

    private static void check(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        Arrays.fill(time[start], Integer.MAX_VALUE);
        boolean[] check = new boolean[n + 1];
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (!check[poll.end]) {
                for (Node next : list[poll.end]) {
                    if (time[start][next.end] > poll.cost + next.cost) {
                        time[start][next.end] = poll.cost + next.cost;
                        queue.add(new Node(next.end, poll.cost + next.cost));
                    }
                }
            }
        }
    }
}
