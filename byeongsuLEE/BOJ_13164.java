package day240717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12933 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int height[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int heightDiff[] = new int[N-1];


        for(int i=0; i<N-1; i++){
            heightDiff[i] = height[i+1] - height[i];
        }

        Arrays.sort(heightDiff);

        int answer = 0 ;
        for(int i = 0 ; i < N-K ;i++){
            answer+=heightDiff[i];;
        }

        System.out.println(answer);

    }


}
