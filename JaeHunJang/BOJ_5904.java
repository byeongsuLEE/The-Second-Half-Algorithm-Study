import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// Moo 게임 / 60분
public class BOJ_5904 {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int length = 3;
        int prev = 3;
        int k = 0;

        while (length < N) {
            k++;
            prev = length;
            length = 2 * prev + (1 + 2 + k);
        }
    }

    static void dfs(int length, int k) {
        int prev = (length - (1 + 2 + k)) / 2;
        if (k == 0) {
            if (N == 1) {
                System.out.print("m");
                return;
            } else {
                System.out.print("o");
                return;
            }
        }
        if (N <= prev) {
            dfs(prev, k-1);
        } else if (prev + 1 <= N && N < prev + (1 + 2 + k)) {
            if (prev + 1 == N) {
                System.out.print("m");
            } else {
                System.out.print("o");
            }
        } else {
            N -= (prev + (1 + 2 + k));
            dfs(prev, k-1);
        }
    }
}