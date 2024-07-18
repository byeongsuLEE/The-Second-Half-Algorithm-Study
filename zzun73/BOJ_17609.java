import java.io.*;

public class Main {
    private static final Character PALINDROME = '0';
    private static final Character SIMILARITY_PALINDROME = '1';
    private static final Character DEFAULT = '2';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sbAnswer = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String str = br.readLine();
            char answer = DEFAULT;

            StringBuilder word = new StringBuilder(str);
            if (str.contentEquals(word.reverse())) {
                answer = PALINDROME;
            } else {
                int left = 0, right = str.length() - 1;
                while (left < right) {
                    if (str.charAt(left) != str.charAt(right)) {
                        StringBuilder wordLeft = new StringBuilder(str).deleteCharAt(left);
                        StringBuilder wordRight = new StringBuilder(str).deleteCharAt(right);

                        if (wordLeft.toString().contentEquals(wordLeft.reverse()) || wordRight.toString().contentEquals(wordRight.reverse())) {
                            answer = SIMILARITY_PALINDROME;
                        }
                        break;

                    }
                    left++;
                    right--;
                }
            }
            sbAnswer.append(answer).append("\n");

        }
        bw.write(sbAnswer.toString());

        br.close();
        bw.close();
    }
}