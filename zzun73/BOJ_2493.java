import java.io.*;
import java.util.*;

public class BOJ_2493 {
    static class Top {
        int height;
        int idx;

        public Top(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }

    static int N;
    static Deque<Top> prev;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        prev = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            Top cur = new Top(Integer.parseInt(st.nextToken()), i + 1); // 입력 순서대로

            // 탑이 남아 있으면서 내가 레이저 쐈을 때 닿지 않는 탑들 제거 (나보다 낮은 탑들)
            while (!prev.isEmpty() && prev.peekLast().height < cur.height) {
                prev.pollLast();
            }

            if (prev.isEmpty()) { // 왼쪽에 탑이 없을 경우 0
                sb.append(0).append(" ");
            } else {
                sb.append(prev.peekLast().idx).append(" "); // 레이저 수신했을 경우
            }

            prev.addLast(cur); // 이전 탑들에 추가

        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}