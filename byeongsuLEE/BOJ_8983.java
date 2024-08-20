
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static class Point implements Comparable<Point> {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Point{" + "r=" + r + ", c=" + c + '}';
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.c, o.c);
        }
    }

    public static StringTokenizer st;
    private static int M;
    private static int N;
    private static int L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] shotPoints = new int[M];
        for (int i = 0; i < M; i++) {
            shotPoints[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(shotPoints);

        Point[] animals = new Point[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            animals[i] = new Point(r, c);
        }

        int count = 0;

        for (Point animal : animals) {
            int r = animal.r;
            int c = animal.c;

            int closestIdx = binarySearchClosest(shotPoints, c);

            boolean isInRange = false;

            if (closestIdx < M && Math.abs(shotPoints[closestIdx] - c) + r <= L) {
                isInRange = true;
            }

            if (closestIdx > 0 && Math.abs(shotPoints[closestIdx - 1] - c) + r <= L) {
                isInRange = true;
            }

            if (isInRange) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static int binarySearchClosest(int[] shotPoints, int target) {
        int left = 0;
        int right = shotPoints.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (shotPoints[mid] == target) {
                return mid;
            } else if (shotPoints[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
