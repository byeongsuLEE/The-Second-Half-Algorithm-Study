import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin = br.readLine();
        String target = br.readLine();

        // 알파벳 빈도수 저장 배열 (26 크기, A-Z에 대응)
        int[] alpha = new int[26];
        
        // 원소 검사 (알파벳 빈도수 비교)
        for (int i = 0; i < origin.length(); i++) {
            // 각 문자를 'A'를 기준으로 0부터 25까지의 배열 인덱스로 변환
            alpha[origin.charAt(i) - 'A']++;
            alpha[target.charAt(i) - 'A']--;
        }
        
        // 알파벳 빈도수 검사
        for (int i = 0; i < 26; i++) {
            if (alpha[i] != 0) {
                System.out.print(-1); // 구성 요소가 다르면 -1 출력
                return;
            }
        }

        // 이동 횟수 계산
        int moveCount = 0;
        int o_idx = origin.length() - 1;
        int t_idx = target.length() - 1;
        
        // 뒤에서부터 비교하면서 일치하지 않는 문자의 개수를 셈
        while (o_idx >= 0) {
            if (origin.charAt(o_idx) != target.charAt(t_idx)) {
                moveCount++;
            } else {
                t_idx--;
            }
            o_idx--;
        }

        System.out.print(moveCount); // 이동 횟수 출력
    }
}
