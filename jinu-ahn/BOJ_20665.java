import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Time{
    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Time{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
public class BOJ_20665 {
    static final int MIN_TIME = 9 * 60;
    static final int MAX_TIME = 21 * 60;
    static boolean[][] visited;
    static List<Time> times = new ArrayList<>();
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        visited = new boolean[MAX_TIME][N+1];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String start = st.nextToken();
            String end = st.nextToken();
            int startHour = Integer.parseInt(start.substring(0,2)) * 60;
            int startMinute = Integer.parseInt(start.substring(2));
            int endHour = Integer.parseInt(end.substring(0,2)) * 60;
            int endMinute = Integer.parseInt(end.substring(2));
            times.add(new Time(startHour+startMinute, endHour+endMinute));
        }
        times.sort(((o1, o2) -> {
            if (o1.start == o2.start)
                return o1.end - o2.end;
            return o1.start - o2.start;
        }));




        for (Time time : times) {
            int start = time.start;
            int end = time.end;
            int seat = findSeat(start);

            for (int i = start; i < end; i++) {
                visited[i][seat] = true;
            }
        }

        int answer = 720;
        for (int i = MIN_TIME; i < MAX_TIME; i++) {
            if (visited[i][P]) {
                answer--;
            }
        }
        System.out.println(answer);
    }
    static int findSeat(int start) {
        int max = Integer.MIN_VALUE;
        int pos = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[start][i]) {
                int dist = getDistance(start, i);
                if (max < dist) { // 가장 멀리 앉을 수 있는 곳을 반환 할 거야
                    max = dist;
                    pos = i;
                }
            }
        }
        return pos;
    }

    static int getDistance(int start, int num) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            if (i == num) continue;
            if (visited[start][i]) {
                min = Math.min(Math.abs(i - num),min);
            }
        }
        return min;
    }
}
