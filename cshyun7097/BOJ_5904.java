import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5904 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int length = 3;
        int pr = 3;
        int k = 0;

        while (length < N) {
            k++;
            pr = length;
            length = 2 * pr + (1 + 2 + k);
        }
        moo(length, k);
    }

    private static void moo(int length, int k) {
        int pr = (length - (1 + 2 + k)) / 2;
        if (k == 0) {
            if (N == 1) {
                System.out.println("m");
                return;
            } else {
                System.out.println("o");
                return;
            }
        }

        if (N <= pr){
            moo(pr, k - 1);
        } else if (pr + 1 <= N && N < pr + (1 + 2 + k)) {
            if (pr + 1 == N) System.out.println('m');
            else System.out.println('o');
        } else {
            N -= (pr + (1 + 2 + k));
            moo(pr, k - 1);
        }
    }
}
