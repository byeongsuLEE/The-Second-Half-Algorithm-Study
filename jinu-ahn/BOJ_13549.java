import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13549 {
    static boolean[] visited = new boolean[100_001];
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N,K);

        System.out.println(result);
    }

    static void bfs(int N , int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        pq.offer(new int[]{N,0});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(cur[0] == K) {
                result = Math.min(cur[1],result);
                break;
            }
            if(cur[0] >= 0 && cur[0] <= 100_000 && !visited[cur[0]]) {
                visited[cur[0]] = true;
                pq.offer(new int[]{cur[0]*2,cur[1]});
                pq.offer(new int[]{cur[0]+1,cur[1]+1});
                pq.offer(new int[]{cur[0]-1,cur[1]+1});
            }
        }
    }
}
