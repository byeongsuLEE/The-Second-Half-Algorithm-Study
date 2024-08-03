import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;


public class Main {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        String num = br.readLine();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i<N ; i++){
            int curnum = num.charAt(i)-'0';
            while(!stack.isEmpty() && stack.peek()<curnum && K!=0){
                    stack.pop();
                    K--;
                }
            stack.add(curnum);
        }
        while(K>0){
            stack.pop();
            K--;
        }
        StringBuilder answer = new StringBuilder();
        while(!stack.isEmpty()){
            answer.append(stack.pop());
        }
        answer.reverse();
        System.out.println(answer.toString());

    }


}
