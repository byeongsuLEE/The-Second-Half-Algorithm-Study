import java.io.*;
import java.util.*;

public class BOJ_20495 {
    static int n;
    static int[] l, r;
    static List<Integer> left, right;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 최대 N은 500,000 이고 넉넉히 선언한다.
        l = new int[505050];
        r = new int[505050];

        left = new ArrayList<>();
        right = new ArrayList<>();

        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
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
        for (int i = 0; i < n; i++) {
            sb.append(lower_bound(right, l[i]) + 1).append(" ");
            sb.append(upper_bound(left, r[i])).append("\n");
        }

        System.out.println(sb.toString());
    }

    // lower bound는 찾고자 하는 값 이상이 처음 나타나는 위치
    static int lower_bound(List<Integer> list, int val) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= val) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    // upper bound는 찾고자 하는 값 이상이 처음 나타나는 위치
    static int upper_bound(List<Integer> list, int val) {
        int left = 0;
        int right = list.size();
        while (left < right) {
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
