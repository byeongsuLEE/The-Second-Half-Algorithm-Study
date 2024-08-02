package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int start;
    int end;
    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Node o) {
        if(this.start == o.start){
            return this.end - o.end;
        }else{
            return this.start - o.start;
        }
    }
}


public class BOJ_19598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Node> meeting = new ArrayList<>();
        List<Integer> now = new ArrayList<>();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            meeting.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(meeting);

        int result = 1;
        now.add(meeting.get(0).end);

        for(int i = 1; i < n; i++){
            int start = meeting.get(i).start;
            int end = meeting.get(i).end;
            boolean check = false;

            for(int j = 0; j < now.size(); j++){
                if(start >= now.get(j)){
                    check = true;
                    now.remove(j);
                    now.add(end);
                    break;
                }
            }

            if(!check){
                result++;
                now.add(end);
            }
        }
        System.out.println(result);
    }
}
