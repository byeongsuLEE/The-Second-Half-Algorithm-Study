package dya240713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_21758_꿀따기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 누적합 배열 계산
        long[] prefixSum = new long[N];
        prefixSum[0] = num[0];
        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i - 1] + num[i];
        }

        long totalSum = prefixSum[N - 1];
        long answerMaxSum = -1;

        // 맨 왼쪽에 꿀통 두고, 맨 오른쪽에 벌 한 개 두기, 벌 이동시키기
        for (int i = 1; i < N - 1; i++) {
            long leftSum = totalSum - num[0] - num[i];
            long rightSum = totalSum - prefixSum[i];
            answerMaxSum = Math.max(answerMaxSum, leftSum + rightSum);
        }

        //  맨 오른쪽에 꿀통 두고, 맨 왼쪽에 벌 두기
        for (int i = 1; i < N - 1; i++) {
            long leftSum = totalSum - num[N - 1] - num[i];
            long rightSum = prefixSum[i - 1];
            answerMaxSum = Math.max(answerMaxSum, leftSum + rightSum);
        }

        //  맨 왼쪽 벌 두고, 맨 오른쪽 벌 두고, 꿀통을 가운데 두기
        for (int i = 1; i < N - 1; i++) {
            long leftSum = prefixSum[i] - num[0];
            long rightSum = totalSum - prefixSum[i - 1] - num[N - 1];
            answerMaxSum = Math.max(answerMaxSum, leftSum + rightSum);
        }

        System.out.println(answerMaxSum);
    }
}
