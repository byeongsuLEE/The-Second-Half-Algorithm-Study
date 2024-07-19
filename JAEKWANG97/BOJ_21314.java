package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_21314 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static String input;

    private static StringBuilder min;
    private static StringBuilder max;

    public static void main(String[] args) throws IOException {
        input = br.readLine();
        searchMax();
        searchMin();

        System.out.println(max);
        System.out.println(min);
    }

    private static void searchMin() {
        int idx = 0;
        char prevChar = 'P';
        min = new StringBuilder();
        while (true) {
            if (idx == input.length()) {
                return;
            }

            if (input.charAt(idx) == 'M' && prevChar != 'M') {
                prevChar = input.charAt(idx);
                idx++;
                min.append(1);
            } else if (input.charAt(idx) == 'M' && prevChar == 'M') {
                prevChar = input.charAt(idx);
                idx++;
                min.append(0);
            } else if (input.charAt(idx) == 'K') {
                prevChar = input.charAt(idx);
                idx++;
                min.append(5);

            }

        }
    }

    private static void searchMax() {
        int idx = 0;
        int count = 0;
        char prevChar = 'M';
        max = new StringBuilder();
        while (true) {
            if (idx == input.length()) {
                return;
            }

            if (input.charAt(idx) == 'M' && prevChar == 'M' && idx != input.length() - 1) {
                max.append(1);
                for (int i = 0; i < count; i++) {
                    max.append(0);
                }
                return;
            } else if (input.charAt(idx) == 'M' && prevChar == 'M') {
                count += 1;
                idx++;
            } else if (input.charAt(idx) == 'M' && idx == input.length() - 1) {
                max.append(1);
                return;
            } else if (input.charAt(idx) == 'M' && prevChar != 'M') {
                prevChar = input.charAt(idx);
                max.append(1);
                idx++;
            } else if (input.charAt(idx) == 'K') {
                max.append(5);
                for (int i = 0; i < count; i++) {
                    max.append(0);
                }
                count = 0;
                idx++;
            }
        }
    }

}
