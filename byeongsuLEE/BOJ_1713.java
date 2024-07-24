import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
 
    static class Student implements Comparable<Student> {
        int index; // 학생의 인덱스
        int count; // 추천받은 수
        int order; // 순서

        Student(int index, int count, int order) {
            this.index = index;
            this.count = count;
            this.order = order;
        }

        @Override
        public int compareTo(Student o) {
            if (this.count == o.count) {
                return this.order - o.order;
            }
            return this.count - o.count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 사진틀의 개수
        int totalRecommendations = Integer.parseInt(br.readLine()); // 총 추천 횟수

        List<Student> frames = new ArrayList<>();
        Map<Integer, Student> studentMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < totalRecommendations; i++) {
            int studentIndex = Integer.parseInt(st.nextToken());

            if (studentMap.containsKey(studentIndex)) {
                studentMap.get(studentIndex).count++;
            } else {
                if (frames.size() == N) {
                    Collections.sort(frames);
                    Student removedStudent = frames.remove(0);
                    studentMap.remove(removedStudent.index);
                }

                Student newStudent = new Student(studentIndex, 1, i);
                frames.add(newStudent);
                studentMap.put(studentIndex, newStudent);
            }
        }

        frames.sort(Comparator.comparingInt(o -> o.index));

        StringBuilder sb = new StringBuilder();
        for (Student student : frames) {
            sb.append(student.index).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
