import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_16719 {

    private static class TrimString implements Comparable<TrimString> {
        public char[] str;
        public TrimString(char[] str) {
            this.str = str;
        }
        public int compareTo(TrimString o) {
            return String.valueOf(str).replace(" ", "").compareTo(String.valueOf(o.str).replace(" ", ""));
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] arr = br.readLine().toCharArray();
        char[] answer = new char[arr.length];
        Arrays.fill(answer, ' ');
         for (int i = 0; i < arr.length; i++) {
             PriorityQueue<TrimString> pq = new PriorityQueue<>();
             for (int j = 0; j < arr.length; j++) {
                 if (answer[j] == ' ') {
                     char[] tmp = Arrays.copyOf(answer, answer.length);
                     tmp[j] = arr[j];
                     pq.offer(new TrimString(tmp));
                 }
             }
             TrimString ts = pq.poll();
             answer = ts.str;
             sb.append(String.valueOf(answer).replace(" ", ""));
             sb.append("\n");
             //System.out.println(Arrays.toString(answer));
         }
        System.out.println(sb);
    }
}
