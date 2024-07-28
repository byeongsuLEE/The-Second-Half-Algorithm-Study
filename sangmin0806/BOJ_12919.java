import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12919 {
    static int len = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        len = T.length();
        System.out.println(dfs(S,T));
    }
    public static int dfs(String S, String T){
        if(S.length()==T.length()){
            if(S.equals(T)){
                return 1;
            }
            return 0;
        }

        int ans = 0;
        String str = "";
        if(T.charAt(0)=='B'){
            str = T.substring(1);
            StringBuilder sb = new StringBuilder(str);
            String temp = sb.reverse().toString();
            ans += dfs(S,temp);
        }
        if(T.charAt(T.length()-1)=='A') {
            str = T.substring(0,T.length()-1);
            ans += dfs(S,str);
        }


        return ans>0?1:0;
    }
}
