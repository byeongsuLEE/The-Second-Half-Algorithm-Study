import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12933 {
    static final char[] DUCK = {'q', 'u', 'a', 'c', 'k'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        if (arr.length % 5 != 0) {
            System.out.println(-1);
            return;
        }

        int charCnt = arr.length;
        int cnt = 0;
        while (charCnt != 0) {
            int point = 0;
            int idx = 0;
            boolean flag = false;
            int[] tmp = new int[5];
            while (idx < arr.length) {
                if (arr[idx] == DUCK[point]) {
                    tmp[point++] = idx;
                    if (point == 5) {
                        flag = true;
                        charCnt -= 5;
                        point = 0;
                        for (int i = 0; i < 5; i++) {
                            arr[tmp[i]] = '\0';
                        }
                    }
                }
                idx++;
            }
            if (flag) cnt++;
            else break;
        }
        System.out.println(charCnt == 0 ? cnt : -1);
    }
}
