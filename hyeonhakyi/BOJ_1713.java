package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1713 {
    static class Node implements Comparable<Node> {
        int idx;
        int num;
        int cnt;

        public Node(int idx, int num, int cnt) {
            this.idx = idx;
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            if(this.cnt == o.cnt){
                return this.idx - o.idx;
            }
            return this.cnt - o.cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int student = Integer.parseInt(st.nextToken());

            if(list.size() < n){
                boolean check = false;

                for(Node node : list){
                    if(node.num == student){
                        node.cnt++;
                        check = true;
                        break;
                    }
                }

                if(!check){
                    list.add(new Node(i, student, 1));
                }
            }else{
                Collections.sort(list);
                boolean check = false;

                for(Node node : list){
                    if(node.num == student){
                        node.cnt++;
                        check = true;
                        break;
                    }
                }
                if(!check){
                    list.remove(0);
                    list.add(new Node(i, student, 1));
                }
            }
        }

        for(Node i : list){
            answer.add(i.num);
        }
        Collections.sort(answer);

        for(int i : answer){
            System.out.print(i + " ");
        }
    }//main end
}//class end
