import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20495 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] minRange = new long[N];
        long[] maxRange = new long[N];
        int[] originalIndices = new int[N];

        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            minRange[i] = a - b;
            maxRange[i] = a + b;
            originalIndices[i] = i;
        }

        long[] sortedMinRange = minRange.clone();
        long[] sortedMaxRange = maxRange.clone();
        Arrays.sort(sortedMinRange);
        Arrays.sort(sortedMaxRange);

        int[] minIndex = new int[N];
        int[] maxIndex = new int[N];

        for (int i = 0; i < N; ++i) {
            minIndex[i] = lowerBound(sortedMaxRange, minRange[i]) + 1;
        }

        for (int i = 0; i < N; ++i) {
            maxIndex[i] = upperBound(sortedMinRange, maxRange[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            sb.append(minIndex[i]).append(" ").append(maxIndex[i]).append("\n");
        }
        System.out.print(sb);
    }

    static int lowerBound(long[] sortedArray, long value) {
        int left = 0, right = sortedArray.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (sortedArray[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    static int upperBound(long[] sortedArray, long value) {
        int left = 0, right = sortedArray.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (sortedArray[mid] <= value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
