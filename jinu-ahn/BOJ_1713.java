import javax.swing.text.Element;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

class ElementSchool {
    int student;
    int recommend;
    int order;

    public ElementSchool(int student, int recommend, int order) {
        this.student = student;
        this.recommend = recommend;
        this.order = order;
    }

    @Override
    public String toString() {
        return "ElementSchool{" +
                "student=" + student +
                ", recommend=" + recommend +
                ", order=" + order +
                '}';
    }
}
public class BOJ_1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int recommendNumber = Integer.parseInt(br.readLine());

        List<ElementSchool> students = new ArrayList<>();
        boolean[] choice = new boolean[101];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        a : for (int i = 0; i < recommendNumber; i++) {
            int student = Integer.parseInt(st.nextToken());
            if(choice[student]) {
                for (ElementSchool elementSchool : students) {
                    if(elementSchool.student == student) {
                        elementSchool.recommend++;
                        continue a;
                    }
                }
            }

            if(count < N) {
                students.add(new ElementSchool(student,1,i));
                choice[student] = true;
                count++;
            }
            else {
                Collections.sort(students,((o1, o2) -> {
                    if(o1.recommend == o2.recommend)
                        return o1.order - o2.order;
                    return o1.recommend - o2.recommend;
                }));
                choice[students.get(0).student] = false;
                choice[student] = true;
                students.remove(0);
                students.add(0,new ElementSchool(student,1,i));

            }
        }
        if(count > 1) {
            Collections.sort(students, ((o1, o2) -> {
                return o1.student - o2.student;
            }));
        }

        for (ElementSchool student : students) {
            System.out.print(student.student + " ");
        }
    }
}
