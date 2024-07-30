import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_21944 {
	static class Problem implements Comparable<Problem> {
        int no;
        int level;
        int group;

        public Problem(int no, int level, int group) {
            this.no = no;
            this.level = level;
            this.group = group;
        }

        @Override
        public int compareTo(Problem o) {
            if (level == o.level) {
                return Integer.compare(no, o.no);
            }
            return Integer.compare(level, o.level);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Problem other = (Problem) obj;
            return no == other.no && level == other.level && group == other.group;
        }

        @Override
        public int hashCode() {
            return Objects.hash(no, level, group);
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        TreeSet<Problem> allProblems = new TreeSet<>();
        List<TreeSet<Problem>> groupProblems = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            groupProblems.add(new TreeSet<>());
        }
        HashMap<Integer, int[]> problemInfo = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            int group = Integer.parseInt(st.nextToken());
            Problem problem = new Problem(no, level, group);
            allProblems.add(problem);
            groupProblems.get(group).add(problem);
            problemInfo.put(no, new int[] {level, group});
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("recommend")) {
                int group = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    sb.append(groupProblems.get(group).last().no).append("\n");
                } else {
                    sb.append(groupProblems.get(group).first().no).append("\n");
                }
            } else if (command.equals("recommend2")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    sb.append(allProblems.last().no).append("\n");
                } else {
                    sb.append(allProblems.first().no).append("\n");
                }
            } else if (command.equals("recommend3")) {
                int x = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    Problem candidate = allProblems.ceiling(new Problem(0, level, 0));
                    if (candidate == null) sb.append("-1\n");
                    else sb.append(candidate.no).append("\n");
                } else {
                    Problem candidate = allProblems.lower(new Problem(0, level, 0));
                    if (candidate == null) sb.append("-1\n");
                    else sb.append(candidate.no).append("\n");
                }
            } else if (command.equals("add")) {
                int no = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                int group = Integer.parseInt(st.nextToken());
                Problem problem = new Problem(no, level, group);
                allProblems.add(problem);
                groupProblems.get(group).add(problem);
                problemInfo.put(no, new int[] {level, group});
            } else if (command.equals("solved")) {
                int no = Integer.parseInt(st.nextToken());
                if (!problemInfo.containsKey(no)) continue;
                int level = problemInfo.get(no)[0];
                int group = problemInfo.get(no)[1];
                Problem problem = new Problem(no, level, group);
                allProblems.remove(problem);
                groupProblems.get(group).remove(problem);
                problemInfo.remove(no);
            }
        }
        System.out.println(sb.toString());
    }

    
}
