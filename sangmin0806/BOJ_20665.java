import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_20665 {
    static int N,T,P;
    static int[][] arr;
    static boolean[][]seat;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        arr = new int[T][2];
        seat = new boolean[1360][N+1];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String start = st.nextToken();
            String end = st.nextToken();
            int startNum = Integer.parseInt(start.substring(0,2))*60;
            startNum += Integer.parseInt(start.substring(2,4));
            int endNum = Integer.parseInt(end.substring(0,2))*60;
            endNum += Integer.parseInt(end.substring(2,4));
            arr[i][0] = startNum;
            arr[i][1] = endNum;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return Integer.compare(o1[1],o2[1]);
                }
                return Integer.compare(o1[0],o2[0]);
            }
        });
        for (int i = 0; i < T; i++) {
            int seatNum = findSeat(arr[i][0]);
            for (int j = arr[i][0]; j < arr[i][1]; j++) {

                seat[j][seatNum] = true;
            }
        }
        int answer = 0;
        for (int i = 540; i < 1260; i++) {
            if(!seat[i][P]) answer++;
        }
        System.out.println(answer);

    }
    public static int findSeat(int time){
        int max = 0;
        int num = 0;
        for (int i = 1; i <=N ; i++) {
            if(!seat[time][i]){
                int dist = getDistance(time,i);
                if(max<dist){
                    max = dist;
                    num = i;
                }
            }

        }
        return num;
    }
    public static int getDistance(int time,int num){
        int minDist = 101;
        for (int i = 1; i <= N; i++) {
            if(i==num) continue;
            if(seat[time][i]){
                int dist = Math.abs(i-num);
                if(minDist>dist){
                    minDist = dist;
                }
            }

        }
        return minDist;
    }
}
