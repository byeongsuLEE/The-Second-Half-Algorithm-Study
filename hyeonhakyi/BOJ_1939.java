package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1939 {
    private static class Node {
        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

    static int n, s, e;
    static ArrayList<Node> list[];
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            list[x].add(new Node(y, z));
            list[y].add(new Node(x, z));
            min = Math.min(min, z);
            max = Math.max(max, z);
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        int result = 0;
        while(min <= max){
            int mid = (min + max)/2;
            visited = new boolean[n + 1];

            if(bfs(mid)){
                min = mid + 1;
                result = mid;
            }else{
                max = mid - 1;
            }
        }
        System.out.println(result);
    }//main end

    public static boolean bfs(int mid){
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur == e){
                return true;
            }

            for(int i = 0; i < list[cur].size(); i++){
                if(list[cur].get(i).value >= mid && visited[list[cur].get(i).idx] == false){
                    q.offer(list[cur].get(i).idx);
                    visited[list[cur].get(i).idx] = true;
                }
            }
        }
        return false;
    }
}//class end
