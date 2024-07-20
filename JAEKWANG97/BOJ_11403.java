import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int[][] visit = new int[n + 1][n + 1];
        List<List<Integer>> newArr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            newArr.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i - 1][j - 1] == 1) {
                    newArr.get(i).add(j);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < newArr.size(); i++) {
            queue.add(i);
        }

        List<Integer> startNode = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            startNode.add(i);
        }

        int[][] answer = dfs(visit, startNode, newArr);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    public static int[][] dfs(int[][] visit, List<Integer> startNode, List<List<Integer>> newArr) {
        for (int num : startNode) {
            Stack<Integer> stack = new Stack<>();
            stack.addAll(newArr.get(num));
            while (!stack.isEmpty()) {
                int currentNode = stack.pop();
                if (visit[num][currentNode] == 0) {
                    visit[num][currentNode] = 1;
                    for (int x : newArr.get(currentNode)) {
                        if (!stack.contains(x) && visit[num][x] == 0) {
                            stack.push(x);
                        }
                    }
                }
            }
        }
        return visit;
    }
}
