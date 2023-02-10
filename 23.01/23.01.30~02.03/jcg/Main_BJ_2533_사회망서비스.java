import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_2533_사회망서비스 {
	
	static class Node {
		int cur;
		Node next;
		public Node(int cur, Main_BJ_2533_사회망서비스.Node next) {
			super();
			this.cur = cur;
			this.next = next;
		}
	}
	
	static int N;
	static Node[] tree;
	static boolean[] visited;
	static int[][] DP;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new Node[N+1];
		visited = new boolean[N+1];
		DP = new int[N+1][2];
		
		StringTokenizer st = null;
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			tree[from] = new Node(to, tree[from]);
			tree[to] = new Node(from, tree[to]);
		}
		
		dfs(1);
		System.out.print(Math.min(DP[1][0], DP[1][1]));
	}

	private static void dfs(int curIdx) {
		visited[curIdx] = true;
		DP[curIdx][0] = 1;
		DP[curIdx][1] = 0;
		
		for(Node n = tree[curIdx]; n!=null; n=n.next) {
			if(!visited[n.cur]) {
				visited[n.cur] = true;
				// dfs 탐색
				dfs(n.cur);
				// 현재가 얼리어답터 0이면, 다음 노드는 자유
				DP[curIdx][0] += Math.min(DP[n.cur][0], DP[n.cur][1]);
				// 현재가 얼리어답터 아니면, 다음은 무조건 얼리어답터
				DP[curIdx][1] += DP[n.cur][0];
			}
		}
	}
}
