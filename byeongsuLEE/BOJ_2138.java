import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static char[] finishState;
	private static char[] initState;
	private static int n;
	private static int answer = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		initState = br.readLine().toCharArray();
		finishState = br.readLine().toCharArray();

		char[] copyInit = Arrays.copyOf(initState, n);
		countSwitch(copyInit);
		int minAnswer = answer;
		answer = 0;

		initState[1] = toggleChar(initState[1]);
		initState[0] = toggleChar(initState[0]);
		answer = 1;

		countSwitch(initState);
		minAnswer = Math.min(minAnswer, answer);

		if (minAnswer > n) {
			System.out.println(-1);
		} else {
			System.out.println(minAnswer);
		}

	}

	public static char toggleChar(char c) {
		return c == '0' ? '1' : '0';
	}

	public static void countSwitch(char[] copy) {

		for (int i = 1; i < n - 1; i++) {
			if (copy[i - 1] != finishState[i - 1]) {
				// 1~n-2일경우
				copy[i - 1] = toggleChar(copy[i - 1]);
				copy[i] = toggleChar(copy[i]);
				copy[i + 1] = toggleChar(copy[i + 1]);
				answer++;

			}
		}
		// n-1일떄
		if (copy[n - 1] != finishState[n - 1]) {
			copy[n-2] = toggleChar(copy[n-2]);
			copy[n - 1] = toggleChar(copy[n - 1]);
			answer++;
		}

		for (int i = 0; i < n; i++) {
			if (copy[i] != finishState[i]) {
				answer = 100000;
				break;
			}

		}

	}

}
