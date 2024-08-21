package day0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19951 {
    public static int N,M ;
    public static int [] height ;
    private static int[] sumHeight;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); //연병장의 크기
        M=Integer.parseInt(st.nextToken()); //조교의 수

        height = new int[N+1];
        st= new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            height[i] = Integer.parseInt(st.nextToken());
        }

        sumHeight = new int [N+2];

        for(int i = 0 ; i < M ;i++){
            st = new StringTokenizer(br.readLine());
            int startIndex = Integer.parseInt(st.nextToken());
            int endIndex = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            sumHeight[startIndex] += k;
            sumHeight[endIndex+1] -= k;
        }

        for(int i =1; i<=N+1;i++){
            sumHeight[i] = sumHeight[i-1]+sumHeight[i];

        }


        for(int i = 1 ; i<=N;i++){
            System.out.print(sumHeight[i]+height[i]+" ");
        }

    }
}
