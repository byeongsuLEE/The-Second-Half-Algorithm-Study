import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[6];
        int answer = 0;
        char[] word = br.readLine().toCharArray();
        arr[0] = word.length;
        for (char ch : word) {
            int index = 0;
            if (ch == 'q') {
                index = 1;
            } else if (ch == 'u') {
                index = 2;
            } else if (ch == 'a') {
                index = 3;
            } else if (ch == 'c') {
                index = 4;
            } else if (ch == 'k') {
                index = 5;
            }

            if (arr[index - 1] == 0) {
                System.out.println("-1");
                return;
            }

            arr[index]++;
            arr[index - 1]--;
            answer = Math.max(answer, arr[1] + arr[2] + arr[3] + arr[4]);
        }
        if (arr[5] * 5 != word.length) {
            System.out.println("-1");
            return;
        }
        System.out.println(answer);
    }
}