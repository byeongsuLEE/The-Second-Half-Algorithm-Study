import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N];
        int[] b = new int[N];

        long[] lowerBounds = new long[N];
        long[] upperBounds = new long[N];

        long[] originalLowerBounds = new long[N];
        long[] originalUpperBounds = new long[N];

        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            lowerBounds[i] = (long) a[i] - b[i];
            upperBounds[i] = (long) a[i] + b[i];

            originalLowerBounds[i] = lowerBounds[i];
            originalUpperBounds[i] = upperBounds[i];
        }

        
        Arrays.sort(lowerBounds);
        Arrays.sort(upperBounds);

        int l, h, mid;
        StringBuilder sb = new StringBuilder();

    
        for (int i = 0; i < N; ++i) {
            
            l = 0;
            h = N;
            while (l < h) {
                mid = (l + h) >> 1;
                if (upperBounds[mid] < originalLowerBounds[i]) {
                    l = mid + 1;
                } else {
                    h = mid;
                }
            }
            sb.append(h + 1).append(" ");

           
            l = 0;
            h = N;
            while (l < h) {
                mid = (l + h) >> 1;
                if (lowerBounds[mid] <= originalUpperBounds[i]) {
                    l = mid + 1;
                } else {
                    h = mid;
                }
            }
            sb.append(h).append("\n");
        }

        System.out.print(sb);
    }
}
