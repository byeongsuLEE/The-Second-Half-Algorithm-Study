import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
    static int answer,N,M;
    static int[][] A, nutrient;
    static PriorityQueue<Integer>[][] trees;
    static Queue<int[]> deadtree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); //K년후

        A = new int[N+1][N+1]; //추가할 양분의 양
        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j<=N ; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        nutrient = new int[N+1][N+1]; //땅의 정보
        for(int i =1 ; i<=N ; i++){
            Arrays.fill(nutrient[i],5);
        }

        trees = new PriorityQueue[N+1][N+1]; //나무의 나이
        for(int i = 1 ; i<=N ; i++){
            for(int j = 1 ; j<=N ; j++){
                trees[i][j] = new PriorityQueue<>();
            }
        }

        answer = 0;
        for(int i = 0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); //나무의 위치 x
            int y = Integer.parseInt(st.nextToken()); //나무의 위치 y
            int z = Integer.parseInt(st.nextToken()); //나무의 나이
            trees[x][y].add(z);
            answer++;
        }

        deadtree = new LinkedList<>();
        for(int i = 0 ; i<K ; i++){
            spring();
            summer();
            autumn();
            winter();
        }

        System.out.println(answer);

    }

    public static void spring(){
        for(int i = 1 ; i<=N ; i++){
            for(int j = 1 ; j<=N ; j++){
                ArrayList<Integer> toadd = new ArrayList<>();
                int size = trees[i][j].size();
                for(int k =0 ; k<size ; k++){
                    int age = trees[i][j].poll();
                    if(age <= nutrient[i][j]){
                        nutrient[i][j]-=age;
                        toadd.add(age+1);
                    }else{
                        deadtree.add(new int[] {i,j,age});
                        answer--;
                    }
                }
                for(int x : toadd){
                    trees[i][j].add(x);
                }
            }
        }
    }
    public static void summer(){ //죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가
        while(!deadtree.isEmpty()){
            int[] dtree = deadtree.poll();
            nutrient[dtree[0]][dtree[1]]+=(dtree[2]/2);
        }
    }

    public static void autumn(){ //나이가 5의 배수인 나무의 인접한 8개의 칸에 나이가 1인 나무 번식
        for(int i = 1 ; i<=N ; i++){
            for(int j = 1 ; j<=N ; j++){
                for(int k : trees[i][j]){
                    int age = k;
                    if(age%5==0){
                        for(int d = 0 ; d<8 ;d++){
                            int nr = i+delta[d][0];
                            int nc = j+delta[d][1];
                            if(nr>=1 && nr<=N && nc>=1 && nc<=N){
                                trees[nr][nc].add(1);
                                answer++;
                            }
                        }
                    }
                }

            }
        }

    }
    public static void winter(){ //S2D2가 땅을 돌아다니면서 땅에 양분을 추가
        for(int i=1 ; i<=N ; i++){
            for(int j = 1 ; j<=N ; j++){
                nutrient[i][j] += A[i][j];
            }
        }
    }

}
