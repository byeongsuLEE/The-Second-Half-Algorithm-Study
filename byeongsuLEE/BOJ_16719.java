
import java.io.IOException;
import java.util.Scanner;

/**
 * 작성자   : user
 * 작성날짜 : 2024-07-16
 * 설명    :
 */
public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int length;
    private static boolean[] usedChar;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.next();
        char[] charArray = inputString.toCharArray();
        usedChar = new boolean[charArray.length];
        length = charArray.length;

        dfs(charArray, 0, charArray.length - 1);

        System.out.println(sb.toString());
    }

    private static void dfs(char[] charArray, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return;
        }

        int minIndex = startIndex;
        for (int i = startIndex; i <= endIndex; i++) {
            if (charArray[minIndex] > charArray[i]) {
                minIndex = i;
            }
        }
        usedChar[minIndex] = true;

        for (int i = 0; i < length; i++) {
            if (usedChar[i]) {
                sb.append(charArray[i]);
            }
        }
        sb.append("\n");

        dfs(charArray, minIndex + 1, endIndex);
        dfs(charArray, startIndex, minIndex - 1);
    }
}
