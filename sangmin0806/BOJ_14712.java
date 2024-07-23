import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14712 {
    static int N;
    static int M;
    static boolean[][] map;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N+1][M+1];
        dfs(0);
        System.out.println(answer);
    }
    public static void dfs(int depth){
        if(depth==N*M){
            answer++;
            return;
        }

        int row = depth/M+1;
        int col = depth%M+1;

        if(map[row-1][col-1]&&map[row][col-1]&&map[row-1][col]) {
            dfs(depth + 1);
        }
        else {
            map[row][col] = true;
            dfs(depth+1);
            map[row][col] = false;
            dfs(depth+1);
        }


    }
}
