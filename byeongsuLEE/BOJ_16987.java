
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자   : user
 * 작성날짜 : 2024-08-26
 * 설명    :
 */
public class Main {

    private static int N;
    private static int answer;
    private static Egg[] eggs;

    public static class Egg {
        int strength;
        int weight;

        public Egg(int strength, int weight) {
            this.strength = strength;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Egg{" +
                    "strength=" + strength +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 초기화 및 DFS 브루트포스 탐색
        answer = 0;
        dfs(0, 0); 
        System.out.println(answer);
    }

    private static void dfs(int current, int brokenEggCount) {
        if (current == N) {
            answer = Math.max(answer, brokenEggCount); 
            return;
        }

        if (eggs[current].strength <= 0) {
            dfs(current + 1, brokenEggCount);
            return;
        }

        boolean anyEggHit = false;


        for (int i = 0; i < N; i++) {
            if (i == current || eggs[i].strength <= 0) continue; // 자기 자신이거나 이미 깨진 계란은 건너뜀

            anyEggHit = true;
            eggs[current].strength -= eggs[i].weight;
            eggs[i].strength -= eggs[current].weight;

            int newBrokenEggs = brokenEggCount;
            if (eggs[current].strength <= 0) newBrokenEggs++;
            if (eggs[i].strength <= 0) newBrokenEggs++;

            dfs(current + 1, newBrokenEggs);

            eggs[current].strength += eggs[i].weight;
            eggs[i].strength += eggs[current].weight;
        }


        if (!anyEggHit) {
            dfs(current + 1, brokenEggCount);
        }
    }
}
