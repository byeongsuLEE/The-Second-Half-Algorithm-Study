package day240712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20665_독서실거리두기 {
    static class Time implements Comparable<Time> {
        int startTime, endTime;

        public Time(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Time o) {
            if (startTime == o.startTime) {
                return Integer.compare(endTime, o.endTime);
            }
            return Integer.compare(startTime, o.startTime);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        Time[] time = new Time[T];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(time);
        // 각 좌석의 상태를 시간별로 관리, 1260분까지 관리
        boolean[][] seats = new boolean[N + 1][1261]; 
        for (int i = 0; i < T; i++) {
            int start = time[i].startTime;
            int end = time[i].endTime;
            int startInMinutes = convertToMinutes(start);
            int endInMinutes = convertToMinutes(end);
            int selectedSeat = selectSeat(seats, N, startInMinutes, endInMinutes);
            for (int j = startInMinutes; j < endInMinutes; j++) {
                seats[selectedSeat][j] = true;
            }
        }

        int availableTime = calculateAvailableTime(seats, P);
        System.out.println(availableTime);
    }

    private static int calculateAvailableTime(boolean[][] seats, int P) {
        int totalMinutes = 0;
        for (int i = 540; i < 1260; i++) { 
            if (!seats[P][i]) {
                totalMinutes++;
            }
        }
        return totalMinutes;
    }

    private static int selectSeat(boolean[][] seats, int N, int start, int end) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 1; i <= N; i++) {
            for (int j = start; j < end; j++) {
                if (seats[i][j]) {
                    dist[i] = 0;
                    break;
                }
            }
        }

        int selectedSeat = -1;
        int maxDist = -1;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                int minDist = Integer.MAX_VALUE;
                for (int j = 1; j <= N; j++) {
                    if (i != j && dist[j] != Integer.MAX_VALUE) {
                        minDist = Math.min(minDist, Math.abs(i - j));
                    }
                }
                if (minDist > maxDist) {
                    maxDist = minDist;
                    selectedSeat = i;
                } else if (minDist == maxDist && i < selectedSeat) {
                    selectedSeat = i;
                }
            }
        }
        return selectedSeat;
    }

    private static int convertToMinutes(int time) {
        int hours = time / 100;
        int minutes = time % 100;
        return hours * 60 + minutes;
    }
}
