
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자   : user
 * 작성날짜 : 2024-08-29
 * 설명    :
 */
public class Main {
    private static int R,C;
    private static int[][] map;
    private static boolean[][] visited;
    private static int answer;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st=new StringTokenizer(br.readLine());
        R =  Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int [R][C];
        visited = new boolean[R][C];
        dp = new int[R][C];

        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<C;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1; // 방문하지않았다.
            }
        }

        answer = dfs(0,0);

        System.out.println( answer);

    }


    public static int[] dr = {0,0,-1,1};
    public static int[] dc = {-1,1,0,0};
private static int dfs(int sr, int sc) {
    if (sr == R - 1 && sc == C - 1) {
         return 1 ;
    }

    if(dp[sr][sc]!=-1){
        return dp[sr][sc];
    }


    dp[sr][sc]= 0;
    for(int d = 0 ; d < 4; d++){
        int nr = sr + dr[d];
        int nc = sc + dc[d];

        if(nr <0 || nc < 0 || nr>=R || nc >=C) continue;
        if(map[sr][sc] <=map[nr][nc]) continue;
        dp[sr][sc]+=dfs(nr,nc);
    }


      return dp[sr][sc];
    }
}
