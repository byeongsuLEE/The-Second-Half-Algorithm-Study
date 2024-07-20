package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18116 {
    static int n;
    static int[] parent;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        parent = new int[1000001];
        count = new int[1000001];

        for(int i = 2; i <= 1000000; i++){
            parent[i] = i;
        }

        Arrays.fill(count, 1);

        char command;
        int a,b;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            command = st.nextToken().charAt(0);
            if(command == 'I'){
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                union(a,b);
            }else{
                a = Integer.parseInt(st.nextToken());
                a = find(a);
                sb.append(count[a] + "\n");
            }
        }
        System.out.println(sb);
    }//main end

    private static int find(int a){
        if(a == parent[a]){
            return a;
        }else{
            return parent[a] = find(parent[a]);
        }
    }//find end

    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a < b){
            parent[b] = a;
            count[a] += count[b];
        }else if(a > b){
            parent[a] = b;
            count[b] += count[a];
        }
    }//union end
}//class end
