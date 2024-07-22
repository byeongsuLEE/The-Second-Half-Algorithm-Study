import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_6443 {
    static char[] perm;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while(N --> 0) {
            char[] arr = br.readLine().toCharArray();
            perm = new char[arr.length];
            isSelected = new boolean[arr.length];
            Arrays.sort(arr);
            perm(0,arr.length,arr);
        }
        System.out.println(sb);

    }
    static void perm(int cnt, int size, char[] arr) {
        if(cnt == size) {
            for (int i = 0; i < size; i++) {
                sb.append(perm[i]);
            }
            sb.append("\n");
            return;
        }

        char lastChar = '\0'; // 현재 단계에서 마지막으로 사용된 문자
        for (int i = 0; i < size; i++) {
            if(!isSelected[i] && arr[i] != lastChar) {
                isSelected[i] = true;
                perm[cnt] = arr[i];
                perm(cnt + 1, size, arr);
                isSelected[i] = false;
                lastChar = arr[i];
            }
        }
    }
}
