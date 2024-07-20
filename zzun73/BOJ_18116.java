import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] root, cnt;

    static void init() {
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
            cnt[i] = 1;
        }
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) {
            return;
        }

        if (pa < pb) {
            root[pa] = pb;
            cnt[pb] += cnt[pa];
            cnt[pa] = 0;
        } else {
            root[pb] = pa;
            cnt[pa] += cnt[pb];
            cnt[pb] = 0;
        }
    }

    static int find(int x) {
        if (root[x] == x) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        root = new int[1000001];
        cnt = new int[1000001];
        init();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            if (st.nextToken().charAt(0) == 'I') {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            } else {
                int c = Integer.parseInt(st.nextToken());
                sb.append(cnt[find(c)]).append("\n");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}