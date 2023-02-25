package A202302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1949_우수마을 {
	static int[] popul;
	static Node[] node;
	static int[][] dp;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		popul = new int[N+1];
		node = new Node[N+1];
		dp = new int[N+1][2];
		visited = new boolean[N+1];
		for(int i = 1; i <= N; i++) {
			popul[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			insert(from,to);
			insert(to,from);
		}
		dfs(1);
		System.out.println(Math.max(dp[1][0], dp[1][1]));
	}
	
	private static void dfs(int num) {
		visited[num]=true;
		dp[num][1] = popul[num];
		Node next = node[num];
		while(next!=null) {
			if(visited[next.num]) {
				next = next.next;
				continue;
			}
			dfs(next.num);
			dp[num][1] += dp[next.num][0];
			dp[num][0] += Math.max(dp[next.num][0], dp[next.num][1]);
			next = next.next;
		}
		
	}

	private static void insert(int from, int to) {
		if(node[from]==null) 
			node[from] = new Node(to, null);
		else 
			node[from] = new Node(to, node[from]);
	}

	static class Node{
		Node next;
		int num;
		Node(int num, Node next) {
			this.num = num;
			this.next = next;
		}
	}
}
