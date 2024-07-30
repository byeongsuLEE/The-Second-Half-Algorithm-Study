package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_20495 {
    static int n;
    static int[] l,r;
    static List<Integer> left,right;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        l = new int[505050];
        r = new int[505050];

        left = new ArrayList<>();
        right = new ArrayList<>();

        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            l[i] = a - b;
            r[i] = a + b;

            left.add(l[i]);
            right.add(r[i]);
        }
        Collections.sort(left);
        Collections.sort(right);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(lower(right, l[i]) + 1).append(" ");
            sb.append(upper(left, r[i])).append("\n");
        }
        System.out.println(sb);
    }//main end

    private static int lower(List<Integer> list, int val){
        int left = 0;
        int right = list.size();
        while(left < right){
            int mid = (right + left)/2;
            if(list.get(mid) >= val){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }//lower end

    private static int upper(List<Integer> list, int val){
        int left = 0;
        int right = list.size();
        while(left < right){
            int mid = (right + left)/2;
            if(list.get(mid) <= val){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return right;
    }
}//class end
