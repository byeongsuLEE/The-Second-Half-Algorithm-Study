
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] str = new String[N];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
            int answer = check(str[i]);
            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int check(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                // Either skip the left character or the right character and check if it becomes a palindrome
                if (isPalindrome(str, left + 1, right) || isPalindrome(str, left, right - 1)) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }
        return 0;
    }

    private static boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
