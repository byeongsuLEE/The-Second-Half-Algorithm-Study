import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int answer = 1;
        while (A < B) {
            if (B % 2 == 0) {
                B /= 2;
                answer++;
            } else {
                String str = String.valueOf(B);
                if (str.charAt(str.length() - 1) == '1') {
                    B = Integer.parseInt(str.substring(0, str.length() - 1));
                    answer++;
                } else {
                    answer = -1;
                    break;
                }
            }
        }

        if (A != B) {
            answer = -1;
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
