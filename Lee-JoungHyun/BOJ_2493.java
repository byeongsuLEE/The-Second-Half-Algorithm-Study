import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
    static int N, top, pre;
    static Stack<int[]> dp; // 나보다 왼쪽이면서 나보다 큰놈들
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder(0 + " ");
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new Stack<>();
        st = new StringTokenizer(br.readLine());
        pre = Integer.parseInt(st.nextToken());
        dp.push(new int[]{pre, 0});
        for (int i = 1; i < N; i++) {
            top = Integer.parseInt(st.nextToken());
            //System.out.println();
            while (!dp.isEmpty() && dp.peek()[0] <= top) dp.pop();
            if (dp.isEmpty()) {
                sb.append(0).append(" ");
                dp.push(new int[]{top, i});
            } else {
                sb.append((dp.peek()[1] + 1) + " ");
                dp.push(new int[]{top, i});
            }

            pre = top;
        }
        System.out.println(sb);
    }
}

