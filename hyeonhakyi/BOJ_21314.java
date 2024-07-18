package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_21314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        boolean check = false;

        String big = Big(sb, check, cnt, str);
        String small = Small(sb, check, cnt, str);


        System.out.println(big);
        System.out.println(small);
    }//main end

    private static String Big(StringBuilder sb, boolean check, int cnt, String str) {
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(!check && ch== 'K'){
                sb.append(5);
            }
            if(ch == 'M'){
                cnt++;
                check = true;
            }else if(check && ch == 'K'){
                sb.append(5).append("0".repeat(cnt));
                check = false;
                cnt = 0;
            }
        }
        if(cnt != 0){
            sb.append("1".repeat(cnt));
        }
        return sb.toString();
    }//Big end

    private static String Small(StringBuilder sb, boolean check, int cnt, String str) {
        sb.setLength(0);
        check = false;
        cnt = 0;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(!check && ch== 'K'){
                sb.append(5);
            }
            if(ch == 'M'){
                cnt++;
                check = true;
            }else if(check && ch == 'K'){
                sb.append(1).append("0".repeat(cnt-1)).append(5);
                check = false;
                cnt = 0;
            }
        }
        if(cnt != 0){
            sb.append(1).append("0".repeat(cnt-1));
        }
        return sb.toString();
    }
}//class end
