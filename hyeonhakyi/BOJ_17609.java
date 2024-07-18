package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

//        String[] arr = new String[n];
//        String str = "";

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            System.out.println(palindrome(0, str.length() - 1, str, 0));
        }

    }//main end

    private static int palindrome(int start, int end, String s, int index) {
        if(index >= 2){
            return 2;
        }

        while (start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else{
                return Math.min(palindrome(start + 1, end, s, index + 1), palindrome(start, end - 1, s, index + 1));
            }
        }
        return index;
    }
}//class end
