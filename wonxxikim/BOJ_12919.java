import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class Main {
    static String S,T;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        result = 0;
        dfs(S,T);
        System.out.println(result);

        }

        static void dfs(String s, String t){
            if(s.length()==t.length()){
                if(s.equals(t)) result = 1;
                return ;
            }

            if(t.charAt(t.length()-1)=='A'){
                dfs(s, t.substring(0,t.length()-1));
            }

            if(t.charAt(0)=='B'){
                String next = t.substring(1,t.length());
                StringBuilder sb = new StringBuilder(next);
                dfs(s,sb.reverse().toString());
            }

        }

}
