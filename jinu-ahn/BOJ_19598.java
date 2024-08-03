import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_19598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> meetingRoom = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetingRoom.add(new int[]{start,end});

        }

        Collections.sort(meetingRoom, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        
        pq.offer(meetingRoom.get(0)[1]);
        for (int i = 1; i < N; i++) {
            if(pq.peek() <= meetingRoom.get(i)[0]) {
                pq.poll();
            }
            pq.offer(meetingRoom.get(i)[1]);
        }
        System.out.println(pq.size());
    }
}
