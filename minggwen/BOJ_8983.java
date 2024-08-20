import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_8983 {
    static class Animal {
        int x;
        int y;
        public Animal(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int arr[] = new int [M];
        st = new StringTokenizer(br.readLine());
        for(int m=0;m<M;m++){
            arr[m] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        Animal[] animals = new Animal[N];
        for(int n=0;n<N;n++){
            st = new StringTokenizer(br.readLine());
            animals[n] = new Animal(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        int cnt =0;
        for(Animal animal:animals){
            int left = 0;
            int right = M-1;
            boolean flag = false;
            while(left<=right){
                int mid = (left+right)/2;
                int dist = Math.abs(arr[mid]-animal.x)+animal.y;
                if(dist<=L){
                    flag = true;
                    break;
                }else{
                    if(arr[mid]-animal.x<0){
                        left = mid+1;
                    }else{
                        right = mid-1;
                    }
                }
            }
            if(flag){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
