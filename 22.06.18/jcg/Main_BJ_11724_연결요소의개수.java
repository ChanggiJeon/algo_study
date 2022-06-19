import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_11724_연결요소의개수 {
	/**
	 * 
	 * 1. bfs -> 520ms
	 * 2. find, union -> 804ms
	 * 
	 */
	static int[] parents;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parents = new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			union(from, to);
		}
		int ans = 1;
		for(int i=1; i<N; i++) {
			if(union(i, i+1)) {
				ans++;
			}
		}
		System.out.println(ans);
	}

	private static boolean union(int A, int B) {
		int aRoot = find(A);
		int bRoot = find(B);
		if(aRoot == bRoot) {
			return false;
		}else {
			parents[bRoot] = aRoot;
			return true;
		}
	}

	private static int find(int A) {
		if(A == parents[A]) {
			return A;
		}
		return find(parents[A]);
	}
	
//	static boolean[][] matrix;
//	static boolean[] visited;
//	static int N, M;
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		matrix = new boolean[N+1][N+1];
//		visited = new boolean[N+1];
//		
//		for(int i=0; i<M; i++) {
//			st = new StringTokenizer(br.readLine());
//			int from = Integer.parseInt(st.nextToken());
//			int to = Integer.parseInt(st.nextToken());
//			matrix[from][to] = matrix[to][from] = true;
//		}
//		System.out.println(bfs());
//		
//	}
//
//	private static int bfs() {
//		Queue<Integer> que = new LinkedList<Integer>();
//		int cnt = 0;
//		for(int i=1; i<=N; i++) {
//			if(visited[i]) continue;
//			que.add(i);
//			while(!que.isEmpty()) {
//				int cur = que.poll();
//				for(int j=1; j<=N; j++) {
//					if(matrix[cur][j] && !visited[j] && cur != j) {
//						que.add(j);
//						visited[j] = true;
//					}
//				}
//			}
//			cnt ++;
//		}
//		return cnt;
//	}
}
