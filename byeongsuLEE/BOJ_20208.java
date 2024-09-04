

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int N,M,H;
    public static int [][] map ;
    public static ArrayList<int [] >milks =new ArrayList<>();
    public static boolean [] visitedMilk ;
    public static int [] home = new int[2];
    public static int answer = -1;
    public static int [] dr = {-1,1,0,0};
    public static int [] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print() {
        System.out.println(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    milks.add(new int [] {i,j});
                }
                else if(map[i][j] == 1) {
                    home[0]=i;
                    home[1]=j;
                }

            }
        }
        visitedMilk = new boolean[milks.size()];
    }


    private static void solution() {

        // 변경되는 사항  : 위치, 체력
        /**
         * 풀이방법
         * 1. 현재위치에서 우유 위치로 갈 수 있는지 판단
         * 2. 갈수 있다면 먹고 돌아오면 answer++
         * 3. 그 위치에서 다른 우유를 갈 수 있는지를 판단 (1,2번 반복)
         */

        dfs(home[0],home[1],M,0);

    }

    private static void dfs(int curR, int curC, int curHealth, int curMilkCount) {


        int distance1 = Math.abs(curR-home[0])+Math.abs(curC-home[1]);
        if(distance1 <=curHealth) {
            answer = Math.max(answer, curMilkCount);
        }

        for(int i = 0 ; i < milks.size();i++){
            if(visitedMilk[i]) continue;
            int distance = Math.abs(curR-milks.get(i)[0])+Math.abs(curC-milks.get(i)[1]);
            if(curHealth<distance) continue;
            visitedMilk[i] = true;
            dfs(milks.get(i)[0], milks.get(i)[1],curHealth-distance+H,curMilkCount+1);
            visitedMilk[i] = false;
        }


    }
}
