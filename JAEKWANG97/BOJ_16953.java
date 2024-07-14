import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        int operationCount = 0;

        while (B > A) {
            if (B % 2 == 0) {
                B /= 2;
            } else if (B % 10 == 1) {
                B /= 10;
            } else {
                break; 
            }
            operationCount++;
        }

        if (B == A) {
            System.out.println(operationCount + 1); 
        } else {
            System.out.println(-1); 
        }
    }
}
