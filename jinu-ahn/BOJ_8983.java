import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_8983 {
    static int M,L;
    static int[] hunter;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        hunter = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
            hunter[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(hunter);

        int result = 0;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(binarySearch(x, y)) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static boolean binarySearch(int x, int y) {
        int start = 0;
        int end = M - 1;
        int mid;
        int distance;

        while(start <= end) {
            mid = (start+end)/2;
            distance = Math.abs(x- hunter[mid])+y;

            if(distance <= L) {
                return true;
            }

            if(x == hunter[mid]) {
                return false;
            }

            if(x < hunter[mid]) {
                end = mid - 1;
            }
            else if(x > hunter[mid]) {
                start = mid + 1;
            }
        }

        return false;
    }
}
