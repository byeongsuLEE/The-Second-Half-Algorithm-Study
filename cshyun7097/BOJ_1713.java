import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int total = 0, now = 0, idx = 0;
        int picNum = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        int[] student = new int[picNum];
        int[] recommend = new int[picNum];
        int[] time = new int[picNum];

        total = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < total; i++) {
            now = Integer.parseInt(st.nextToken());
            idx = 0;

            for (int j = 0; j < picNum; j++) {
                if (student[j] == 0 || student[j] == now) {
                    idx = j;
                    break;
                }

                if (recommend[idx] > recommend[j] || recommend[idx] == recommend[j] && time[idx] > time[j]) {
                    idx = j;
                }
            }
            if (student[idx] != now) {
                student[idx] = now;
                recommend[idx] = 0;
                time[idx] = i;
            }

            recommend[idx]++;
        }

        Arrays.sort(student);

        for (int x : student) {
            if (x != 0) {
                sb.append(x).append(" ");
            }
        }
        System.out.println(sb);
    }
}
