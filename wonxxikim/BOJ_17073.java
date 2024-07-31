import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int result;
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken()); //트리의 노드 수
       int W = Integer.parseInt(st.nextToken());// 1번 노드에 고인 물의 양
        list = new ArrayList[N+1];
        for(int i = 1 ; i<=N ; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0 ; i<N-1 ; i++){
           st = new StringTokenizer(br.readLine());
           int U = Integer.parseInt(st.nextToken());
           int V = Integer.parseInt(st.nextToken());
           list[U].add(V);
           list[V].add(U);
       }
        for(int i = 2 ; i<=N ; i++){
            if(list[i].size()==1)result++;
        }
        System.out.println((double)W/result);

    }
   

}
