import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(bfs(A,B));

    }
    static long bfs(int A, int B) {
        long min = -1;
        boolean[] visited = new boolean[1000000001];
        PriorityQueue<long[]> pq = new PriorityQueue<>(((o1, o2) -> {
            if(o1[1] == o2[1]) return (int) ((B-o1[0]) - (B-o2[0]));
            return (int) (o1[1] - o2[1]);
        }));
        pq.offer(new long[]{A,1});

        while(!pq.isEmpty()){
            long[] cur = pq.poll();
            if(cur[0] < 0 || cur[0] > 1000000000) continue;
            if(cur[0] == B) {
                min = cur[1];
                break;
            }

            if(!visited[(int) cur[0]]) {
                visited[(int) cur[0]] = true;
                pq.offer(new long[]{cur[0] * 2, cur[1] + 1});
                pq.offer(new long[]{cur[0] * 10 + 1, cur[1] + 1});
            }
        }

        return min;
    }
}
