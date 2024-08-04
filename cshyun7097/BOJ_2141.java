import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2141 {
    static class House implements Comparable<House>{
        long pos, val;

        public House(long pos, long val) {
            this.pos = pos;
            this.val = val;
        }

        @Override
        public int compareTo(House o) {
            return (int) (this.pos - o.pos);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        List<House> houses = new ArrayList<>();

        long sum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long pos = Long.parseLong(st.nextToken());
            long val = Long.parseLong(st.nextToken());
            houses.add(new House(pos, val));
            sum += val;
        }

        Collections.sort(houses);
        long res = 0;

        for (int i = 0; i < N; i++) {
            res += houses.get(i).val;
            if ((sum + 1) / 2 <= res) {
                System.out.println(String.valueOf(houses.get(i).pos));
                break;
            }
        }
    }
}
