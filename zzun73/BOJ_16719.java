import java.io.*;

public class Main {
    static char[] word;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void helper(int left, int right) {
        if (left > right) {
            return;
        }

        int targetIdx = left;
        for (int i = left; i <= right; i++) {
            if (word[targetIdx] > word[i]) {
                targetIdx = i;
            }
        }
        visited[targetIdx] = true;

        for (int i = 0; i < word.length; i++) {
            if (visited[i]) {
                sb.append(word[i]);
            }
        }
        sb.append("\n");

        helper(targetIdx + 1, right);
        helper(left, targetIdx - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        word = br.readLine().toCharArray();
        visited = new boolean[word.length];
        helper(0, word.length - 1);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}