import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.AbstractMap.SimpleImmutableEntry;

public class Main {
	static class Tree implements Comparable<Tree> {
		int r, c, age;

		@Override
		public String toString() {
			return "Tree [r=" + r + ", c=" + c + ", age=" + age + "]";
		}

		public Tree(int r, int c, int age) {
			super();
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.age, o.age);
		}

	}

	private static int N;
	private static int M;
	private static int K;
	private static int[][] map;
	private static int[][] yangBun;
	private static PriorityQueue<Tree> treeList;
	private static ArrayList<Tree> dieTreeList;
	private static int[] dr = {-1,1,0,0,-1,-1,1,1};
	private static int[] dc  = {0,0,-1,1,-1,1,-1,1};
	private static Object answer;
	private static boolean[][] visited;
	private static PriorityQueue<Tree> nextTreeList;

	public static void main(String[] args) throws IOException {

		init();
		// 시작
		simulation();
		print();

	}

	private static void print() {
		System.out.println(answer);
		
	}

	private static void simulation() {
		// k년동안 봄 여름 가을 겨울 진행
		for(int k = 1; k<=K;k++) {
			
			//봄 진행
			visited=new boolean [N][N];
			nextTreeList = new PriorityQueue<>();
			while(!treeList.isEmpty()) {
				Tree tree= treeList.poll();
				int r = tree.r;
				int c = tree.c;
				int age = tree.age;
				
			
				
				if(age> map[r][c] ) {
					
					dieTreeList.add(tree);
				
				}else {
					map[r][c] -= age;
					tree.age+=1;
					nextTreeList.offer(tree);
				}
			}
			
			//여름
			for(int i = 0 ; i<dieTreeList.size();i++) {
				Tree tree= dieTreeList.get(i);
				map[tree.r][tree.c] += tree.age/2;
			}
			dieTreeList.clear();
				
			treeList = new PriorityQueue<>(nextTreeList);
			//가을 : 나무번식
			
			
			List<Tree> tempTree =new ArrayList<>();
			for (Tree tree : nextTreeList) {
				if (tree.age % 5 == 0) {
					for(int d = 0 ;d<8 ;d++) {
						int nr = tree.r+dr[d];
						int nc = tree.c+dc[d];
						if(nr <0 || nr>=N|| nc<0 || nc>=N) continue;
//						treeList.offer(new Tree(nr,nc,1));
						tempTree.add(new Tree(nr,nc,1));
					}
				}
			}
			treeList.addAll(tempTree);
			//겨울
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j]+=yangBun[i][j];
				}
			}
			
		}
		
		//다끝나면 tree개수구하기
		answer= treeList.size();

		
		
	}

	private static void init() throws IOException {
		// n = 맵의 크기 , m 은 나무의 개수 , k : 년
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		
		map = new int[N][N];
		for(int i = 0 ; i<N;i++) {
			Arrays.fill(map[i], 5);
		}
		
		yangBun = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				yangBun[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		treeList = new PriorityQueue<Tree>();
		dieTreeList = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			treeList.offer(new Tree(r, c, age));
		}
	}

}
