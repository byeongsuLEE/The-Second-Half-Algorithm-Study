import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_9489 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n;
        int k;
        int[][] arr;
        int kIdx = 0;


        while(true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            if(n == 0 && k == 0) break;

            arr = new int[n][2];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i][0] = Integer.parseInt(st.nextToken());
                if(arr[i][0] == k) kIdx = i;
            }
            arr[0][1] = -1;

            int p = 0;
            for (int i = 1; i < n; i++) {
                arr[i][1] = p;
                if(i < n - 1 && arr[i][0] + 1 != arr[i + 1][0]) p++;
            }

            int result = 0;
            if(kIdx != 0) {
                int pp = arr[arr[kIdx][1]][1];
                p = arr[kIdx][1];
                for (int i = 1; i < n; i++) {
                    if(arr[i][1] >= kIdx) break;
                    if(arr[i][1] == -1 || arr[arr[i][1]][1] == -1) continue;
                    else if(arr[arr[i][1]][1] == pp && arr[i][1] != p) result++;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
