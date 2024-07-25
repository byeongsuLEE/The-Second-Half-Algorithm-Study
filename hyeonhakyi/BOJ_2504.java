package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] c = br.readLine().toCharArray();

        int temp = 1;
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < c.length; i++) {
            char ch = c[i];

            if(ch == '('){
                stack.push('(');
                temp *= 2;
            }else if(ch == '['){
                stack.push('[');
                temp *= 3;
            }else if(ch == ')'){
                if(stack.isEmpty() || stack.peek() != '('){
                    System.out.println(0);
                    return;
                }else{
                    if(c[i-1] == '('){
                        answer += temp;
                    }
                    stack.pop();
                    temp /= 2;
                }
            }else if(ch == ']'){
                if(stack.isEmpty() || stack.peek() != '['){
                    System.out.println(0);
                    return;
                }else{
                    if(c[i-1] == '['){
                        answer += temp;
                    }
                    stack.pop();
                    temp /= 3;
                }
            }
        }

        if(!stack.isEmpty()){
            System.out.println(0);
            return;
        }

        System.out.println(answer);
    }//main end
}//class end
