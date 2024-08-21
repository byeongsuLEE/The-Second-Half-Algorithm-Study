import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Tree {
    int x;
    int y;
    int age;
    boolean isDead;

    public Tree(int x, int y, int age) {
        this.x = x;
        this.y = y;
        this.age = age;
    }
}
public class BOJ_16235 {
    static int[][] foods;
    static int[][] lands;
    static ArrayList<Tree> trees;
    static Deque<Integer> deadTrees = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        foods = new int[N][N];
        lands = new int[N][N];
        trees = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                foods[i][j] = Integer.parseInt(st.nextToken());
                lands[i][j] = 5;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x,y,age));
        }

        Collections.sort(trees, (t1, t2) -> t1.age - t2.age);

        while (K != 0) {
            spring();
            summer();
            fall(N);
            winter(N);
            K--;
        }

        System.out.println(trees.size());
    }
    public static void spring() {
        for (int i = 0; i < trees.size(); i++) {
            Tree tree = trees.get(i);
            if (lands[tree.x][tree.y] < tree.age) {
                deadTrees.add(i);
                continue;
            }

            lands[tree.x][tree.y] -= tree.age;
            tree.age++;
        }
    }

    public static void summer() {
        while (!deadTrees.isEmpty()) {
            int deadTreeIndex = deadTrees.pollLast();
            Tree deadTree = trees.get(deadTreeIndex);
            int food = deadTree.age / 2;

            lands[deadTree.x][deadTree.y] += food;
            deadTree.isDead = true;
        }
    }

    public static void fall(int N) {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        ArrayList<Tree> newTrees = new ArrayList<>();
        for (int p = 0; p < trees.size(); p++) {
            Tree tree = trees.get(p);
            if (tree.isDead) {
                continue;
            }
            if (tree.age % 5 == 0) {
                for (int i = 0; i < 8; i++) {
                    int nr = tree.x + dx[i];
                    int nc = tree.y + dy[i];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                        continue;
                    }
                    newTrees.add(new Tree(nr, nc, 1));
                }
            }
        }
        for (Tree tree : trees) {
            if (!tree.isDead) {
                newTrees.add(tree);
            }
        }
        trees = newTrees;
    }

    public static void winter(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                lands[i][j] += foods[i][j];
            }
        }
    }
}
