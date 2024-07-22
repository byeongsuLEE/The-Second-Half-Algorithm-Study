import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    private static StringBuilder sb;
    private static int N;
    private static char[] result;
    private static int[] charCount;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            charCount = new int[26];
            for (char c : word.toCharArray()) {
                charCount[c - 'a']++;
            }
            result = new char[word.length()];
            permutation(0, word.length());
        }
        
        System.out.println(sb.toString());
    }

    private static void permutation(int depth, int length) {
        if (depth == length) {
            sb.append(result).append("\n");
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (charCount[i] > 0) {
                result[depth] = (char) (i + 'a');
                charCount[i]--;
                permutation(depth + 1, length);
                charCount[i]++;
            }
        }
    }
}
