import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_6443 {
    static int N;
    static StringBuilder answer = new StringBuilder();
    static char[] c;
    static PriorityQueue<StringBuilder> pq = new PriorityQueue<>();
    static int[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            c= new char[str.length()];
            check = new int[26];
            for (int j = 0; j < str.length(); j++) {
                c[j] = str.charAt(j);
                check[c[j]-'a']++;
            }
            char[] arr = new char[str.length()];
            recur(0,arr);
            int size = pq.size();
            for (int j = 0; j < size; j++) {
                answer.append(pq.poll()).append("\n");
            }
        }
        System.out.print(answer);
    }
    private static void recur(int depth,char[] arr){
        if(depth==c.length){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
            }
            pq.add(sb);
            return;
        }
        for (int i = 0; i < 26; i++) {
            if(check[i]>0){
                check[i]--;
                arr[depth] = (char)(i+'a');
                recur(depth+1,arr);
                check[i]++;
            }
        }
    }
}
