import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class home implements Comparable<home>{
        int loc;
        int peo;
        public home(int loc, int peo){
            this.loc=loc;
            this.peo=peo;
        }
        public int compareTo(home o){
            return this.loc-o.loc;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        home[] country = new home[N];
        long sum = 0;
        for(int i = 0 ;i<N ; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
            int loc = Integer.parseInt(st.nextToken());
            int peo = Integer.parseInt(st.nextToken());
            country[i] = new home(loc,peo);
            sum+=peo;
        }

        Arrays.sort(country);
        long cnt = 0;
        for(int i = 0 ; i<N ; i++){
            if(cnt+country[i].peo>=(sum+1)/2){
                System.out.println(country[i].loc);
                break;
            }
            cnt+=country[i].peo;
        }


    }


}
