import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] minus = new int[N];
        int[] plus = new int[N];
        ArrayList<Integer> minuslist = new ArrayList<>();
        ArrayList<Integer> pluslist = new ArrayList<>();
        for(int i  = 0 ; i<N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            minus[i] = a-b;
            plus[i] = a+b;
            minuslist.add(minus[i]);
            pluslist.add(plus[i]);
        }

        Collections.sort(minuslist);
        Collections.sort(pluslist);
        for(int i = 0 ; i<N ; i++){
            int min = findmin(pluslist,minus[i])+1;
            int max =findmax(minuslist,plus[i]);
            System.out.println(min+" "+max);
        }

        }
        public static int findmin(ArrayList<Integer> list, int val){
            int left = 0;
            int right = N;
            while(left<right){
                int mid = (left+right)/2;
                if(list.get(mid)>=val) right = mid;
                else left = mid+1;
            }
            return right;
        }

        public static int findmax(ArrayList<Integer> list, int val){
            int left = 0;
            int right = N;
            while(left<right){
                int mid = (left+right)/2;
                if(list.get(mid)<=val) left = mid+1;
                else right = mid;
            }
            return right;
        }

}
