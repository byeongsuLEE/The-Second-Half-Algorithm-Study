package dya240713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Meeeting implements  Comparable<Meeeting>{
        int startTime;
        int endTime;

        public Meeeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "Meeeting{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }

        @Override
        public int compareTo(Meeeting o) {
            if(o.startTime == this.startTime){
                return Integer.compare( this.endTime,o.endTime);
            }
            return Integer.compare(this.startTime, o.startTime);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Meeeting> pq = new PriorityQueue<Meeeting>();
        StringTokenizer st = null;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            pq.offer(new Meeeting(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        PriorityQueue<Integer> endPQ = new PriorityQueue<>();
        while(!pq.isEmpty()){
            Meeeting curMeeting = pq.poll();
            if (!endPQ.isEmpty() && curMeeting.startTime >= endPQ.peek()) {
                endPQ.poll();
            }
            endPQ.offer(curMeeting.endTime);
        }

        System.out.println(endPQ.size());
    }
}
