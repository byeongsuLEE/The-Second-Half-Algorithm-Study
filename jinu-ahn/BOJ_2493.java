import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Top {
    int height;
    int idx;

    public Top(int height, int idx) {
        this.height = height;
        this.idx = idx;
    }
}
public class BOJ_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Top> stack = new Stack<>();
        for (int i = 1; i <= N; i++) {
            Top top = new Top(Integer.parseInt(st.nextToken()),i);
            if(!stack.isEmpty()){
                while(true) {
                    if (stack.peek().height > top.height) {
                        sb.append(stack.peek().idx + " ");
                        stack.push(top);
                        break;
                    } else {
                        stack.pop();
                        if(stack.isEmpty()) {
                            sb.append(0 + " ");
                            stack.push(top);
                            break;
                        }
                    }
                }
            }else {
                stack.push(top);
                sb.append(0 + " ");
            }
        }
        System.out.println(sb);
    }
}
