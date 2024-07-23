import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class BOJ_6443 {

    public static int[] alpha;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {

            alpha = new int[26];

            HashSet<String> set = new HashSet<>();
            LinkedList<String> list = new LinkedList<>();

            char[] input = br.readLine().toCharArray();
            int length = input.length;
            for (char c : input) {
                alpha[c - 'a']++;
            }



            permutation("", length, set, list);
            
            for (String s : list) {
                sb.append(s);
                sb.append("\n");
            }

        }

        System.out.println(sb);
    }

    public static void permutation(String tm, int length, HashSet<String> set, LinkedList<String> list) {
        //System.out.println(tm + " : " + tm.length() + " : " + length);
        if(tm.length() == length) {
            //System.out.println("등록 : " + tm);
            set.add(tm);
            list.add(tm);
            return;
        }

        for(int i = 0; i < alpha.length; i++) {
            if (alpha[i] > 0) {
                alpha[i]--;
                permutation(tm + (char)(i + 'a'), length , set, list);
                alpha[i]++;
            }
        }
    }
}
