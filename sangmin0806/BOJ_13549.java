import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549 {
    static int N;
    static int K;
    static int[] dir = {-1,1};
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        bfs();
    }
    public static void bfs(){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{N,0});
        visited[N] = true;
        while (!que.isEmpty()){
            int[] current = que.poll();
            int place = current[0];
            int time = current[1];
            if(2*place<100001&&!visited[2*place]){
                visited[2*place] = true;
                que.add(new int[]{2*place,time});
            }
            for (int i = 0; i < 2; i++) {
                int next = place+dir[i];
                if(next>=0&&next<100001&&!visited[next]){
                    visited[next] = true;
                    que.add(new int[]{next,time+1});
                }
            }
            if(place==K){
                System.out.println(time);
                return;
            }

        }
    }

}
