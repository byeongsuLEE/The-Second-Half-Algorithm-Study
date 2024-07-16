import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_16719 {
    static String input;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        visited = new boolean[input.length()];
        recursive(0,input.length()-1);
        System.out.println(sb);
    }
    public static void recursive(int left, int right){
        if(left>right)return;
        int min = 999;
        int index = left;
        for (int i = left; i <= right; i++) {
            char c = input.charAt(i);
            if(!visited[i]&&min>c-'A'){
                min = c-'A';
                index = i;
            }
        }
        visited[index] = true;
        for (int i = 0; i < input.length(); i++) {
            if(visited[i]){
                sb.append(input.charAt(i));
            }
        }
        sb.append("\n");
        recursive(index+1,right);
        recursive(left,index-1);
    }
}
