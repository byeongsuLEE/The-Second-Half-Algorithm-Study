import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] nums = new int [N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i<=N ; i++){
            int num = Integer.parseInt(st.nextToken());
            nums[i] = nums[i-1]+num;
        }
        long cnt = 0 ;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 1 ; i<=N ; i++){
            cnt+=map.getOrDefault(nums[i]-K,0);
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        System.out.println(cnt);

    }

}
