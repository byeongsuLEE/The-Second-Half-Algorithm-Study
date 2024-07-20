import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Robot {
    int parent;
    int count;

    public Robot(int parent, int count) {
        this.parent = parent;
        this.count = count;
    }
}
public class BOJ_18116 {
    static Robot[] parent = new Robot[1_000_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= 1_000_000; i++) {
            parent[i] = new Robot(i,1);
        }
        for (int i = 0 ;i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if(command.equals("I")) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }
            else {
                int c = Integer.parseInt(st.nextToken());
                int p = find(parent[c].parent);
                sb.append(parent[p].count).append("\n");
            }
        }

        System.out.println(sb);

    }
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) return;

        parent[x].count+=parent[y].count;
        parent[parent[y].parent].parent = x;
    }
    static int find(int x) {
        if(parent[x].parent == x) return x;
        return parent[x].parent = find(parent[x].parent);
    }
}
