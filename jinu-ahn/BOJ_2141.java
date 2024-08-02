import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class PostOffice{
    int point;
    int people;

    public PostOffice(int point, int people) {
        this.point = point;
        this.people = people;
    }
}
public class BOJ_2141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<PostOffice> postOffices = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int point = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());

            postOffices.add(new PostOffice(point,people));
            sum += people;

        }
        Collections.sort(postOffices,((o1, o2) -> {return o1.point - o2.point;}));

        if(sum % 2 != 0) sum += 1;
        long mid = sum / 2;
        long peoples = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {
            if(peoples + postOffices.get(i).people >= mid) {
                result = postOffices.get(i).point;
                break;
            }
            peoples += postOffices.get(i).people;
        }
        System.out.println(result);
    }
}
