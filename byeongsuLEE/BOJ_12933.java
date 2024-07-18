import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sound = scanner.nextLine();
        scanner.close();
        
        int result = countDucks(sound);
        System.out.println(result);
    }

    public static int countDucks(String sound) {
        if (sound.length() % 5 != 0) {
            return -1; 
        }

        String quack = "quack";
        int[] stages = new int[sound.length()];
        int ducks = 0;
        int maxDucks = 0;

        for (char c : sound.toCharArray()) {
            boolean found = false;
            for (int i = 0; i < ducks; i++) {
                if (quack.charAt(stages[i]) == c) {
                    stages[i]++;
                    if (stages[i] == 5) {
                        stages[i] = 0; 
                    }
                    found = true;
                    break;
                }
            }
            if (!found) {
                if (c == 'q') {
                    stages[ducks++] = 1; // 새로운 오리의 울음 시작
                    maxDucks = Math.max(maxDucks, ducks);
                } else {
                    return -1; 
                }
            }
        }

        for (int i = 0; i < ducks; i++) {
            if (stages[i] != 0) {
                return -1; 
            }
        }

        return maxDucks;
    }
}
