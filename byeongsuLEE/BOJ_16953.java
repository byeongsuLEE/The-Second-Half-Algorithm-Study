package dya240713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16953 {
    public static int minAnswerCount = 1234567890;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        //재귀로 모든 경우를 구해보면되지않을까?
        dfs(a,b,0);

        System.out.print(minAnswerCount==1234567890 ? -1:minAnswerCount+1);
    }

    private static void dfs(long curNum, long resultNum, int operationCount) {
        if(minAnswerCount <operationCount || curNum > resultNum) {
           return ;
        }
        if(curNum==resultNum){
            minAnswerCount = Math.min(minAnswerCount,operationCount);
            return ;
        }

        // 2를 곱한다
        dfs(curNum*2, resultNum, operationCount+1);

        // 1을 수의 가장 오른쪽에 추가한다.
        long addOneNum= Long.parseLong(String.valueOf(curNum)+"1");

        dfs(addOneNum, resultNum, operationCount+1);

    }
}
