import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12933 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[5];

        int num = 0;
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c=='q'){
                num++;
                arr[0]++;
            }else if(c=='u'){

                if(arr[1]>=num){
                    num++;
                }
                arr[1]++;
                for (int j = 0; j < 1; j++) {
                    if(arr[j]<arr[1]){
                        System.out.println(-1);
                        return;
                    }
                }

            }else if(c=='a'){

                if(arr[2]>=num){
                    num++;

                }
                arr[2]++;
                for (int j = 0; j < 2; j++) {
                    if(arr[j]<arr[2]){
                        System.out.println(-1);
                        return;
                    }
                }

            }else if(c=='c'){

                if(arr[3]>=num){
                    num++;

                }
                arr[3]++;
                for (int j = 0; j < 3; j++) {
                    if(arr[j]<arr[3]){
                        System.out.println(-1);
                        return;
                    }
                }

            }else if(c=='k'){
                arr[4]++;
                for (int j = 0; j < 4; j++) {
                    if(arr[j]<arr[4]){
                        System.out.println(-1);
                        return;
                    }
                }
                for (int j = 0; j < 5; j++) {
                    arr[j]--;
                }
                num--;
            }
            max = Math.max(num,max);
        }
        for (int i = 0; i < 5; i++) {
            if(arr[i]!=0){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(max);
    }
}
