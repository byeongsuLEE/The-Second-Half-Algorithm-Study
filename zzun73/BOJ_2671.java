import java.io.*;
import java.util.regex.Pattern;

public class BOJ_2671 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        Pattern pattern = Pattern.compile("(100+1+|01)+");

        bw.write(pattern.matcher(input).matches() ? "SUBMARINE" : "NOISE");

        br.close();
        bw.close();
    }
}