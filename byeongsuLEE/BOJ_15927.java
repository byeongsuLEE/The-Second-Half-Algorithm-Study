import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        boolean hasDifferentAdjacent = false;
        int length = input.length();
        
        for (int i = 0; i < length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - i - 1)) {
                System.out.println(length);
                return;
            }
          
            hasDifferentAdjacent = (input.charAt(i) != input.charAt(i + 1)) ? true : hasDifferentAdjacent;
        }
        System.out.println(hasDifferentAdjacent ? length - 1 : -1);
    }
}
