import java.io.*;
import java.util.*;

public class Main {
    static class Candidate implements Comparable<Candidate> {
        int id;
        int votes;
        int time;

        public Candidate(int id, int votes, int time) {
            this.id = id;
            this.votes = votes;
            this.time = time;
        }

        @Override
        public int compareTo(Candidate o) {
            if (this.votes == o.votes) {
                return this.time - o.time;
            }
            return this.votes - o.votes;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int totalVotes = Integer.parseInt(br.readLine());

        Map<Integer, Candidate> map = new HashMap<>();
        PriorityQueue<Candidate> pq = new PriorityQueue<>();
        int time = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < totalVotes; i++) {
            int student = Integer.parseInt(st.nextToken());
            time++;

            if (map.containsKey(student)) {
                Candidate candidate = map.get(student);
                pq.remove(candidate);
                candidate.votes++;
                pq.add(candidate);
            } else {
                if (map.size() >= N) {
                    map.remove(pq.poll().id);
                }
                Candidate candidate = new Candidate(student, 1, time);
                map.put(student, candidate);
                pq.add(candidate);
            }
        }

        List<Integer> result = new ArrayList<>(map.keySet());
        Collections.sort(result);

        for (int id : result) {
            sb.append(id).append(" ");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}