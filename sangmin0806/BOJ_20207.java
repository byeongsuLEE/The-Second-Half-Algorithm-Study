import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20207 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[366];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j <= end; j++) {
                arr[j]++;
            }
        }
        int sum = 0;
        int width = 0;
        int height = 0;
        for (int i = 1; i <366; i++) {
            if(arr[i]==0){
                sum+=width*height;
                height = 0;
                width = 0;
            }else {
                width++;
                height = Math.max(height,arr[i]);
            }
        }
        sum+=width*height;
        System.out.println(sum);
    }
}
