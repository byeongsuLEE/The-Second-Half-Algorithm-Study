import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;


public class Main {
    static int answer;
    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;
        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int compareTo(Meeting o){
            if(this.start==o.start) return this.end-o.end;
            return this.start-o.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Meeting> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Meeting(start, end));

        }
        Collections.sort(list);

        ArrayList<Integer> time = new ArrayList<>();
        time.add(0);
        for (int i = 0; i < list.size(); i++) {
            Meeting meeting = list.get(i);
            for (int j = 0; j < time.size(); j++) {
                if (time.get(j) <= meeting.start) {
                    time.remove(j);
                    break;
                }
            }
            time.add(meeting.end);
        }

        System.out.println(time.size());

    }

}
