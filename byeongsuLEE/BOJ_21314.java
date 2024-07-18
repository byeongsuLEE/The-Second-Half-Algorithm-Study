package day240718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_21314 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();


        //COMMON k가 연속으로 나오면 그냥 5적으셈

        String max = "";
        String min = "";
        char[] charArray = str.toCharArray();
        Queue<Character> q = new LinkedList<Character>();

        for (int i = 0; i < charArray.length; i++) {
            q.offer(charArray[i]);
        }

        int mCount = 0;
        int kCount = 0;

        while (!q.isEmpty()) {
            char currentChar = q.poll();
            if (currentChar == 'M') {
                mCount++;
            } else {
                //계산 후 mcount = 0;으로 두기
                if (mCount == 0) {
                    max += 5;
                    min += 5;
                } else { // mk  mmk mmmmmmmmmmmk 같은거
                    max += "5";
                    for (int i = 0; i < mCount; i++) {
                        max += "0";
                    }


                    min += "1";
                    for (int i = 0; i < mCount - 1; i++) {
                        min += "0";
                    }
                    min += "5";

                }
                mCount = 0;

            }

        }
        //추가계산
        if (mCount != 0) {
            for (int i = 0; i < mCount; i++) {
                max += "1";
            }
            min += "1";
            for (int i = 0; i < mCount - 1; i++) {
                min += "0";
            }
        }

        System.out.println(max);
        System.out.println(min);


        //최대값
        // MK로 K로 끝나고 M이랑같이있으면 무조권합치라


        //최소값
        //M이 연속이면 같이묶자
        //KMK같이 M이한개면 분리시켜버리자

    }
}
