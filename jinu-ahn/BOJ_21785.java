import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());

        int[] honeys = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            honeys[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(Math.max(leftHoney(honeys), Math.max(rightHoney(honeys),midHoney(honeys))));
    }
    static int leftHoney(int[] honeys) {
        int[] sum = new int[honeys.length];

        for (int i = honeys.length-2 ; i >= 1; i--) {
            sum[i] = sum[i+1] + honeys[i+1];
        }

        int max = Integer.MIN_VALUE;

        for (int i = 2; i < honeys.length; i++) {
            max = Math.max(max, sum[1] - honeys[i] + sum[i]);
        }
        return max;
    }

    static int rightHoney(int[] honeys) {
        int[] sum = new int[honeys.length];

        for (int i = 2 ; i < honeys.length; i++) {
            sum[i] = sum[i-1] + honeys[i-1];
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i < honeys.length-1; i++) {
            max = Math.max(max, sum[honeys.length-1] - honeys[i] + sum[i]);
        }
        return max;
    }

    static int midHoney(int[] honeys) {
        int[] leftSum = new int[honeys.length];
        int[] rightSum = new int[honeys.length];

        for (int i = 2 ; i < honeys.length; i++) {
            leftSum[i] = leftSum[i-1] + honeys[i];
        }
        for (int i = honeys.length-2 ; i >= 1; i--) {
            rightSum[i] = rightSum[i+1] + honeys[i];
        }


        int max = Integer.MIN_VALUE;

        for (int i = 1; i < honeys.length; i++) {
            max = Math.max(max, rightSum[i] + leftSum[i]);
        }
        return max;
    }
}
