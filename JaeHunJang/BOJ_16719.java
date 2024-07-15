import java.io.BufferedReader;
import java.io.InputStreamReader;

// ZOAC / 60분
import java.io.*;
import java.util.*;

public class BOJ_16719 {
    static boolean[] visited;
    static String str;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        int leng = str.length();
        visited = new boolean[leng];

        for (int i = 0; i < leng; ++i) {
            PriorityQueue<String> pq = new PriorityQueue<>();
            Map<String, Integer> indexMap = new HashMap<>();

            for (int j = 0; j < leng; ++j) {
                if (!visited[j]) {
                    StringBuilder temp = new StringBuilder();
                    for (int k = 0; k < leng; ++k) {
                        if (k == j || visited[k])
                            temp.append(str.charAt(k));
                    }
                    String tempStr = temp.toString();
                    pq.offer(tempStr);
                    indexMap.put(tempStr, j);
                }
            }

            if (!pq.isEmpty()) {
                String smallest = pq.poll();
                System.out.println(smallest);
                visited[indexMap.get(smallest)] = true;
            }
        }
    }
}
