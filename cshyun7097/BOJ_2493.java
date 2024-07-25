import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Stack<int[]> building = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int input = Integer.parseInt(st.nextToken());
            while (true) {
                if (!building.isEmpty()) {
                    int top = building.peek()[1];
                    if (top > input) {
                        sb.append(building.peek()[0]).append(" ");
                        building.push(new int[]{i, input});
                        break;
                    } else {
                        building.pop();
                    }
                } else {
                    sb.append(0).append(" ");
                    building.push(new int[]{i, input});
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
