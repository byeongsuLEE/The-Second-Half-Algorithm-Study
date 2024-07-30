import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20495 {
    static int N;
    static int[] l, r;
    static List<Integer> left, right;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        l = new int[505050];
        r = new int[505050];

        left = new ArrayList<>();
        right = new ArrayList<>();

        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int ai = Integer.parseInt(st.nextToken());
            int bi = Integer.parseInt(st.nextToken());
            l[i] = ai - bi;
            r[i] = ai + bi;

            left.add(l[i]);
            right.add(r[i]);
        }

        Collections.sort(left);
        Collections.sort(right);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(lowerBound(right, l[i]) + 1).append(" ");
            sb.append(upperBound(left, r[i])).append("\n");
        }
        System.out.println(sb);
    }

    static int lowerBound(List<Integer> list, int val) {
        int left = 0;
        int right = list.size();
        while(left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= val) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    static int upperBound(List<Integer> list, int val) {
        int left = 0;
        int right = list.size();
        while(left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) <= val) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
