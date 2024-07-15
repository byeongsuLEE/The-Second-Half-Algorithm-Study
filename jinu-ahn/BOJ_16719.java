import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] arr = br.readLine().toCharArray();

        zoac(0,arr.length-1,sb,new boolean[arr.length],arr);

        System.out.println(sb);
    }
        private static void zoac(int left, int right,StringBuilder sb, boolean[] visited, char[] arr) throws IOException {
            if (left > right) return;

            int idx = left;

            for (int i = left; i <= right; i++) {
                if (arr[idx] > arr[i]) {
                    idx = i;
                }
            }
            visited[idx] = true;
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    sb.append(arr[i]);
                }
            }
            sb.append("\n");
            zoac(idx + 1, right,sb,visited,arr);
            zoac(left, idx  - 1,sb,visited,arr);
        }
}
