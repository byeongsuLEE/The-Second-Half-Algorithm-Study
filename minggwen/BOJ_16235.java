import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16235 {
	static class Tree implements Comparable<Tree>{
		int x,y,z;
		public Tree(int x, int y, int z) {
			this.x=x;
			this.y=y;
			this.z=z;
		}
		@Override
		public int compareTo(Tree o) {
			
			return this.z-o.z;
		}
		@Override
		public String toString() {
			return "Tree [x=" + x + ", y=" + y + ", z=" + z + "]";
		}
		
	}

	static int N,M,K;
	static int[][] origin, map;
	static PriorityQueue<Tree> trees;
	static PriorityQueue<Tree> dieTrees;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		origin = new int [N][N];
		map = new int [N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}
		trees = new PriorityQueue<>();
		dieTrees = new PriorityQueue<>();
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
			trees.add(new Tree(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())));
			
		}
		for(int k=0;k<K;k++) {
			spring();
			summer();
			autumn();
			winter();
		}
		System.out.println(trees.size());

	}
	private static void spring() {
		Queue<Tree> que = new ArrayDeque<Tree>();
		while(!trees.isEmpty()) {
			Tree t = trees.poll();
			if(map[t.x][t.y]>=t.z) {
				map[t.x][t.y]-=t.z;
				t.z++;
				que.add(t);
			}else {
				dieTrees.add(t);
			}
		}
		while(!que.isEmpty()) {
			trees.add(que.poll());
		}
	}
	private static void summer() {
		while(!dieTrees.isEmpty()) {
			Tree t = dieTrees.poll();
			map[t.x][t.y]+=t.z/2;
		}
	}
	private static void autumn() {
		int delta[][] = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
		Queue<Tree> newTree = new ArrayDeque<>();
		for(Tree t:trees) {
			for(int d=0;d<8;d++) {
				if(t.z%5!=0)continue;
				int rx = t.x+delta[d][0];
				int ry = t.y+delta[d][1];
				if(isIn(rx,ry)) {
					newTree.add(new Tree(rx,ry,1));
				}
			}
		}
		while(!newTree.isEmpty()) {
			trees.add(newTree.poll());
		}
		
	}
	private static void winter() {
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				map[r][c]+=origin[r][c];
			}
		}
	}
	private static boolean isIn(int x,int y) {
		return 0<=x&&x<N&&0<=y&&y<N?true:false;
	}

}
