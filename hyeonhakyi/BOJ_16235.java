package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16235 {
    private static class Tree implements Comparable<Tree>{
        int x;
        int y;
        int age;
        public Tree(int x,int y,int age){
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return Integer.compare(this.age,o.age);
        }
    }
    private static int n,m,k;
    private static int[][] arr;
    private static int[][] graund;
    private static int[] dx = {-1,-1,-1,0,0,1,1,1};
    private static int[] dy = {-1,0,1,-1,1,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];
        graund = new int[n+1][n+1];
        Deque<Tree> list = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                graund[i][j] = 5;
            }
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            list.add(new Tree(x,y,z));
        }

        while (k > 0){
            Queue<Tree> die_list = new LinkedList<>();

            for(int i = 0; i < list.size();){
                Tree now = list.poll();
                if(graund[now.x][now.y] >= now.age){
                    graund[now.x][now.y] -= now.age;
                    now.age++;
                    i++;
                    list.add(now);
                }else{
                    die_list.add(now);
                }
            }

            for(Tree t : die_list){
                graund[t.x][t.y] += t.age/2;
            }

            Queue<Tree> temp_list = new LinkedList<>();
            for(Tree t : list){
                if(t.age% 5 == 0){
                    temp_list.add(t);
                }
            }

            while (!temp_list.isEmpty()){
                Tree t = temp_list.poll();

                for(int d = 0; d < 8; d++){
                    int nx = t.x + dx[d];
                    int ny = t.y + dy[d];

                    if(nx >= 1 && ny >= 1 && nx <= n && ny <= n){
                        list.addFirst(new Tree(nx,ny,1));
                    }
                }
            }

            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    graund[i][j] += arr[i][j];
                }
            }
            k--;
        }
        System.out.println(list.size());
    }//main end
}//class end

