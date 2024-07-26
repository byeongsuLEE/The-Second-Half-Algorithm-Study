import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18352 {
    static int N,M,K;
    static boolean[] visited;
    static List<Integer>[] node;
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N+1];
        node = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            node[start].add(end);
        }
        bfs(X);

        if(result.isEmpty()) System.out.println(-1);
        else {
            Collections.sort(result);
            for (Integer i : result) {
                System.out.println(i);
            }
        }

    }
    static void bfs(int start) {
        Queue<int[]> pq = new ArrayDeque<>();
        pq.offer(new int[]{start,0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(cur[1] == K) result.add(cur[0]);

            if(cur[1] > K) continue; // 이미 최단거리보다 커지면 로직을 수행할 이유가 없음 (가지치기)

            for (Integer i : node[cur[0]]) {
                if(!visited[i]) {
                    visited[i] = true;
                    if(start != i)
                        pq.offer(new int[]{i,cur[1]+1});
                }
            }
        }
    }
}
