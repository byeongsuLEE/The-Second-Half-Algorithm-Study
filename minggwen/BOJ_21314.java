import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_21314 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] arr = str.toCharArray();
        int m = 0;
        StringBuilder max = new StringBuilder();
        StringBuilder min = new StringBuilder();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'M') {
                m++;
            } else {
                if (m > 0) {
                    max.append('5');
                    for (int j = 0; j < m; j++) {
                        max.append('0');
                    }
                    min.append('1');
                    for (int j = 1; j < m; j++) {
                        min.append('0');
                    }
                    min.append('5');
                } else {
                    max.append('5');
                    min.append('5');
                }
                m = 0;
            }
        }
        
        if (m > 0) {
            for (int i = 0; i < m; i++) {
                max.append('1');
            }
            min.append('1');
            for (int i = 1; i < m; i++) {
                min.append('0');
            }
        }
        
        System.out.println(max.toString());
        System.out.println(min.toString());
    }
}
