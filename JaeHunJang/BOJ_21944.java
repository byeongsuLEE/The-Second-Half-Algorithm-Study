import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 문제 추천 시스템 Version 2 / 60분
public class BOJ_21944 {
	static class Problem implements Comparable<Problem> {
		int id, level, category;

		public Problem(int id, int level, int category) {
			this.id = id;
			this.level = level;
			this.category = category;
		}

		@Override
		public int compareTo(Problem o) {
			if (this.level == o.level) return this.id - o.id;
			return this.level - o.level;
		}
	}

	static TreeMap<Integer, Problem> allProblems = new TreeMap<>();
	static TreeMap<Integer, TreeSet<Problem>> categoryMap = new TreeMap<>();
	static TreeMap<Integer, TreeSet<Problem>> levelMap = new TreeMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			Problem problem = new Problem(P, L, G);
			allProblems.put(P, problem);
			categoryMap.putIfAbsent(G, new TreeSet<>());
			categoryMap.get(G).add(problem);
			levelMap.putIfAbsent(L, new TreeSet<>());
			levelMap.get(L).add(problem);
		}

		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch (command) {
				case "add":
					int P = Integer.parseInt(st.nextToken());
					int L = Integer.parseInt(st.nextToken());
					int G = Integer.parseInt(st.nextToken());
					addProblem(P, L, G);
					break;
				case "recommend":
					int category = Integer.parseInt(st.nextToken());
					int x = Integer.parseInt(st.nextToken());
					sb.append(recommend(category, x)).append("\n");
					break;
				case "recommend2":
					int dir = Integer.parseInt(st.nextToken());
					sb.append(recommend2(dir)).append("\n");
					break;
				case "recommend3":
					int dir3 = Integer.parseInt(st.nextToken());
					int l = Integer.parseInt(st.nextToken());
					sb.append(recommend3(dir3,l)).append("\n");
					break;
				case "solved":
					int id = Integer.parseInt(st.nextToken());
					solveProblem(id);
					break;
			}
		}

		System.out.print(sb.toString());
	}

	static void addProblem(int id, int level, int category) {
		Problem problem = new Problem(id, level, category);
		allProblems.put(id, problem);
		categoryMap.computeIfAbsent(category, k -> new TreeSet<>()).add(problem);
		levelMap.computeIfAbsent(level, k -> new TreeSet<>()).add(problem);
	}

	static int recommend(int category, int x) {
		if (categoryMap.containsKey(category)) {
			TreeSet<Problem> set = categoryMap.get(category);
			return x == 1 ? set.last().id : set.first().id;
		}
		return -1;
	}

	static int recommend2(int dir) {
		return dir == 1 ? allProblems.lastEntry().getValue().id : allProblems.firstEntry().getValue().id;
	}

	static int recommend3(int dir, int diff) {
		if (dir == 1) {  // 주어진 난이도보다 높은 문제 중에서 가장 낮은 난이도를 찾음
			SortedMap<Integer, TreeSet<Problem>> subMap = levelMap.tailMap(diff + 1);
			if (!subMap.isEmpty()) {
				TreeSet<Problem> problems = subMap.get(subMap.firstKey());
				if (!problems.isEmpty()) {
					return problems.first().id;
				}
			}
		} else {  // 주어진 난이도보다 낮은 문제 중에서 가장 높은 난이도를 찾음
			SortedMap<Integer, TreeSet<Problem>> subMap = levelMap.headMap(diff);
			if (!subMap.isEmpty()) {
				TreeSet<Problem> problems = subMap.get(subMap.lastKey());
				if (!problems.isEmpty()) {
					return problems.first().id;
				}
			}
		}
		return -1;  // 적합한 문제가 없는 경우 -1 반환
	}



	static void solveProblem(int id) {
		if (allProblems.containsKey(id)) {
			Problem problem = allProblems.remove(id);
			categoryMap.get(problem.category).remove(problem);
			levelMap.get(problem.level).remove(problem);
		}
	}
}
