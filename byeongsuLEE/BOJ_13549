package day0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 작성자   : user
 * 작성날짜 : 2024-07-19
 * 설명    :
 */
public class Main_13549 {
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        System.out.println(bfs(N,K));
    }

    private static int bfs(int n, int k) {
        boolean[] visited = new boolean[100001];
        int dx[] = {-1, 1, 2};
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });

        pq.offer(new int[]{n, 0});
        visited[n] = true;

        while (!pq.isEmpty()) {


            int[] cur = pq.poll();
            int x = cur[0];
            int time = cur[1];


            if (x == k) {

                return time;
            }
            for (int d = 0; d < 3; d++) {
                int nx = x + dx[d];
                if(d==2) nx = x* dx[d];

                if (nx < 0 || nx > 100000) continue;
                if (visited[nx]) continue;
                visited[x] = true;
                int ntime = 0;
                ntime = d == 2 ? time : time+1;
                pq.offer(new int[]{nx, ntime});


            }

        }
        return -1;
    }
}
