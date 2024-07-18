package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_12933 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        boolean[] visited = new boolean[arr.length];
        int k = 0;
        char[] duck = {'q','u','a','c','k'};
        int cnt = 0;
        if(arr[0] != 'q' || arr.length % 5 != 0){
            System.out.println(-1);
            return;
        }

        for(int i = 0; i < arr.length; i++){
            ArrayList<Character> list = new ArrayList<>();
            for(int j = i; j < arr.length; j++){
                if(!visited[j] && arr[j] == duck[k]){
                    k++;
                    list.add(arr[j]);
                    visited[j] = true;
                    if(k == 5){
                        k = 0;
                    }
                }
            }
            if(list.size() != 0){
                if(list.get(list.size()-1) != 'k'){
                    System.out.println(-1);
                    return;
                }
                cnt++;
            }
        }
        System.out.println(cnt);
    }//main end
}//class end
