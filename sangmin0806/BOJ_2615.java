import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2615    {
    static int[] dr = {0,1,1,-1};
    static int[] dc = {1,1,0,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[19][19];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<19;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int color = -1;

        for(int i = 0; i<19;i++) {
            for(int j = 0; j<19; j++) {
                int count = 0;
                if(map[i][j]!=0) {
                    color = map[i][j];
                    count++;
                    for(int k = 0; k<4;k++) {
                        int brow =i-dr[k];
                        int bcol = j-dc[k];
                        int nrow = i+dr[k];
                        int ncol = j+dc[k];
                        if(nrow<0||ncol<0||nrow>=19||ncol>=19) continue;
                        if(brow>=0&&bcol>=0&&brow<19&&bcol<19) {
                            if(map[brow][bcol]==color) continue;
                        }

                        if(map[nrow][ncol]==color) {
                            count++;
                            for(int l = 0;l<4;l++) {
                                nrow += dr[k];
                                ncol += dc[k];
                                if(nrow<0||ncol<0||nrow>=19||ncol>=19) continue;
                                if(map[nrow][ncol]==color) {
                                    count++;
                                }
                                else if(l<3&&map[nrow][ncol]!=color){
                                    count =1;
                                    break;
                                }

                            }
                            if(count==6) {
                                count=1;
                            }
                            else if(count==5) {
                                sb.append(color).append("\n").append(i+1).append(" ").append(j+1);
                                System.out.println(sb);
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(0);

    }
}


