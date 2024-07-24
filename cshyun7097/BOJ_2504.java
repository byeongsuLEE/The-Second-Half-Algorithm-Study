import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int tmp = 1;
        int res = 0;
        boolean able = true;

        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if (now == '[') {
                stack.push(now);
                tmp *= 3;
            } else if (now == '(') {
                stack.push(now);
                tmp *= 2;
            } else if (now == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    able = false;
                    break;
                }
                if (str.charAt(i - 1) == '[') {
                    res += tmp;
                }
                stack.pop();
                tmp /= 3;
            } else if (now == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    able = false;
                    break;
                }
                if (str.charAt(i - 1) == '(') {
                    res += tmp;
                }
                stack.pop();
                tmp /= 2;
            } else {
                able = false;
                break;
            }
        }
        if (!stack.isEmpty() || !able) {
            System.out.println(0);
        } else {
            System.out.println(res);
        }
    }
}
