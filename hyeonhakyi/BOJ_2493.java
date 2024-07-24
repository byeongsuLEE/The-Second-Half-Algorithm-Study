package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
    static class Node{
        int num;
        int height;
        public Node(int num, int height){
            this.num = num;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Stack<Node> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int height = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()){
                sb.append("0 ");
                stack.push(new Node(i, height));
            }else{
                while(true){
                    if(stack.isEmpty()){
                        sb.append("0 ");
                        stack.push(new Node(i, height));
                        break;
                    }
                    Node node = stack.peek();

                    if(node.height > height){
                        sb.append(node.num + " ");
                        stack.push(new Node(i, height));
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
        }
        System.out.println(sb.toString() + "\n");
    }//main end
}//class end
