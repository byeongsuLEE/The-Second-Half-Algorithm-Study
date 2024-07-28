import java.io.*;

public class BOJ_12919 {
    static String S;
    static int sLength, answer;

    static void helper(String target) {
        if (target.length() == sLength) {
            if (target.equals(S)) {
                answer = 1;
            }
            return;
        }

        if (target.endsWith("A")) {
            helper(target.substring(0, target.length() - 1));
        }

        if (target.startsWith("B")) {
            helper(new StringBuilder(target.substring(1)).reverse().toString());
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        S = br.readLine();
        String T = br.readLine();
        sLength = S.length();

        helper(T);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}