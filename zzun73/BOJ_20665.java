import java.io.*;
import java.util.*;

public class Main {

    static class Reservation implements Comparable<Reservation> {
        int start;
        int end;

        public Reservation(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Reservation o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }

    static int N, T, P;


    public static int selectSeat(Map<Integer, Reservation> usingSeats) {
        int select = 0;
        int maxDist = Integer.MIN_VALUE;
        List<Integer> seats = new ArrayList<>(usingSeats.keySet());
        Collections.sort(seats);
        int firstSeat = seats.get(0);
        int lastSeat = seats.get(seats.size() - 1);

        if (firstSeat != 1) {
            int dist = firstSeat - 1;
            if (dist > maxDist) {
                maxDist = dist;
                select = 1;
            }
        }
        for (int i = 1; i < seats.size(); i++) {
            int dist = (seats.get(i) - seats.get(i - 1)) / 2;
            if (dist > maxDist) {
                maxDist = dist;
                select = seats.get(i - 1) + dist;
            }
        }

        if (lastSeat != N) {
            int dist = N - lastSeat;
            if (dist > maxDist) {
                select = N;
            }
        }
        return select;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        T = Integer.parseInt(line[1]);
        P = Integer.parseInt(line[2]);
        PriorityQueue<Reservation> pq = new PriorityQueue<>();

        for (int i = 0; i < T; i++) {
            line = br.readLine().split(" ");
            int sh = Integer.parseInt(line[0].substring(0, 2));
            int sm = Integer.parseInt(line[0].substring(2));
            int eh = Integer.parseInt(line[1].substring(0, 2));
            int em = Integer.parseInt(line[1].substring(2));
            pq.add(new Reservation((sh * 60) + sm, (eh * 60) + em));
        }

        Map<Integer, Reservation> usingSeats = new HashMap<>();
        int adminTime = 720;
        while (!pq.isEmpty()) {
            Reservation reservation = pq.poll();
            int curTime = reservation.start;


            List<Integer> seatNums = new ArrayList<>(usingSeats.keySet());
            for (Integer num : seatNums) {
                int start = usingSeats.get(num).start;
                int end = usingSeats.get(num).end;
                if (curTime >= end) {
                    if (num == P) {
                        adminTime -= (end - start);
                    }
                    usingSeats.remove(num);
                }
            }

            if (usingSeats.isEmpty()) {
                usingSeats.put(1, reservation);
            } else {
                int selectNum = selectSeat(usingSeats);
                usingSeats.put(selectNum, reservation);
            }
        }

        if (usingSeats.containsKey(P)) {
            adminTime -= (usingSeats.get(P).end - usingSeats.get(P).start);
        }
        bw.write(String.valueOf(adminTime));
    }
}