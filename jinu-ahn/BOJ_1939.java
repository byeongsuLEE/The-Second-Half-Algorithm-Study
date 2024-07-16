import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Bridge {
    int from;
    int dist;

    public Bridge(int from, int dist) {
        this.from = from;
        this.dist = dist;
    }

    @Override
    public String toString() {
        return "Bridge{" +
                "from=" + from +
                ", dist=" + dist +
                '}';
    }
}
public class BOJ_1939 {
    static List<Bridge>[] bridges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        bridges = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            bridges[i] = new ArrayList<>();
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            max = Math.max(max,dist);
            min = Math.min(min,dist);
            bridges[to].add(new Bridge(from,dist));
            bridges[from].add(new Bridge(to,dist));
        }

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int result = 0;
        while(min <= max) {
            int mid = (min + max) / 2;

            if(bfs(A,B,mid,new boolean[N+1])){
                min = mid + 1;
                result = mid;
                continue;
            }
            max = mid - 1;

        }

        System.out.println(result);
    }

    static boolean bfs(int start, int target, int mid, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(cur == target) return true;
            for(int i = 0; i < bridges[cur].size(); i++) {
                if(bridges[cur].get(i).dist >= mid && !visited[bridges[cur].get(i).from]) {
                    visited[bridges[cur].get(i).from] = true;
                    queue.offer(bridges[cur].get(i).from);
                }
            }
        }
        return false;
    }
}
