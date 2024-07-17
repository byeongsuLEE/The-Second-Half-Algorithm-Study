import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Duck {
    char[] sound = {'q','u','a','c','k'};
    Stack<Character> duckSound;
    int nextStr;

    public Duck() {
        duckSound = new Stack<>();
        nextStr = 0;
    }

    public boolean addStr(char next) {
        if(sound[nextStr] == next) {
            duckSound.push(next);
            nextStr = ++nextStr % 5;
            return true;
        }
        return false;
    }
}
public class BOJ_12933 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] sound = br.readLine().toCharArray();

        Duck[] ducks = new Duck[501];
        ducks[0]= new Duck();
        int idx = 1;
        boolean flag = false;
        a : for (char c : sound) {
            for (int i = 0; i < idx; i++) {
                if(ducks[i].addStr(c)) {
                    continue a;
                }
            }
            if(c == 'q') {
                ducks[idx] = new Duck();
                ducks[idx++].nextStr++;
            }
            else {
                flag = true;
                break;
            }
        }

        for (int i = 0; i < idx; i++) {
            if(ducks[i].nextStr != 0) {
                flag = true;
                break;
            }
        }
        System.out.println(!flag ? idx : -1);
    }
}
