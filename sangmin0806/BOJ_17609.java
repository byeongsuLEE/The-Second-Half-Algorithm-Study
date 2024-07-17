import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_17609 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();

        for(int t=0;t<T;t++){
            String s = bf.readLine();
            sb.append(checkPalindrome(s,0,0,s.length()-1));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int checkPalindrome(String s,int result, int start,int last){

        if(result==2){
            return 2;
        }

        while(start<=last){

            if(s.charAt(start) == s.charAt(last)){
                start++;
                last--;
            }
            else{
                result = Integer.min(checkPalindrome(s,result+1,start+1,last),checkPalindrome(s,result+1,start,last-1));
                break;
            }
        }

        return result;
    }
}