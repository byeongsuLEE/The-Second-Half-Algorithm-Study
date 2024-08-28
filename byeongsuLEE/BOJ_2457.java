import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static class Flower implements Comparable<Flower> {
        int start, end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower o) {
            if (this.start == o.start) {
                return o.end - this.end; // 시작일이 같다면 종료일이 늦은순
            }
            return this.start - o.start; // 시작일이 빠른순
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Flower> flowers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int startMonth = Integer.parseInt(input[0]);
            int startDay = Integer.parseInt(input[1]);
            int endMonth = Integer.parseInt(input[2]);
            int endDay = Integer.parseInt(input[3]);
            int start = startMonth * 100 + startDay;
            int end = endMonth * 100 + endDay;
            flowers.add(new Flower(start, end));
        }

        Collections.sort(flowers);

        int currentEnd = 301; 
        int nextEnd = 0;
        int count = 0;
        int i = 0;

        while (currentEnd <= 1130) {
            boolean found = false;
            while (i < n && flowers.get(i).start <= currentEnd) {
                nextEnd = Math.max(nextEnd, flowers.get(i).end);
                i++;
                found = true;
            }

            if (!found) { 
                System.out.println(0);
                return;
            }

            count++;
            currentEnd = nextEnd;
        }

        System.out.println(count);
    }
}
