import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_21314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] mingyum = br.readLine().toCharArray();
        String max = "";
        String min = "";
        int mCount = 0;

        for (char c : mingyum) {
            if(c == 'K') {
                // max 구하기
                max += "5";
                for (int i = 0; i < mCount; i++) {
                    max += "0";
                }

                // min 구하기
                if(mCount != 0) {
                    min += "1";
                    for (int i = 0; i < mCount - 1; i++) {
                        min += "0";
                    }
                }
                min += "5";
                mCount = 0;
                continue;
            }
            mCount++;
        }

        if(mCount != 0) {
            for (int i = 0; i < mCount; i++) {
                max += "1";
            }
            min += "1";
            for (int i = 0; i < mCount - 1; i++) {
                min += "0";
            }
        }

        System.out.println(max + "\n" + min);
    }
}
