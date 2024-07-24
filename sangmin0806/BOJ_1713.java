import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class BOJ_1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] input = new int[K];
        for (int i = 0; i < K; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int[] student = new int[101];//추천수
        List<Integer> frame = new ArrayList<>();//학생번호
        for (int i = 0; i < K; i++) {
            if(student[input[i]]==0){
                if(frame.size()<N){
                    frame.add(input[i]);
                    student[input[i]]++;
                }
                else {
                    int min = Integer.MAX_VALUE;
                    int index = 0;
                    int studentnum =0;
                    for (int j = 0; j < frame.size(); j++) {
                        studentnum = frame.get(j);
                        if(min>student[studentnum]){
                            min = student[studentnum];
                            index = j;
                        }
                    }
                    student[frame.get(index)] = 0;
                    student[input[i]]++;
                    frame.remove(index);
                    frame.add(input[i]);

                }
            }else {
                student[input[i]]++;
            }

        }
        Collections.sort(frame, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < frame.size(); i++) {
            sb.append(frame.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}
