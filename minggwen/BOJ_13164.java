import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int K = Integer.parseInt(firstLine[1]);
        
        String[] secondLine = br.readLine().split(" ");
        int[] heights = new int[N];
        
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(secondLine[i]);
        }
        
        int[] diffs = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            diffs[i] = heights[i + 1] - heights[i];
        }
        
        Arrays.sort(diffs);
        
        int totalCost = 0;
        for (int i = 0; i < N - K; i++) {
            totalCost += diffs[i];
        }
        
        System.out.println(totalCost);
    }
}
