import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1260_DFS와BFS {
	/**
	 * 1. ArrayList로 sort하기 -> 264ms
	 * 2. 2차원 배열로 만들어서 각각 1000 * 1000으로 계산(100만) -> 300ms
	 * 
	 */
	static int N, M, V;
	static boolean[][] matrix;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		matrix = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			matrix[from][to] = true;
			matrix[to][from] = true;
		}
		
		dfs(V);
		sb.append("\n");
		visited = new boolean[N+1];
		
		bfs(V);
		System.out.println(sb);
	}

	private static void bfs(int cur) {
		Queue<Integer> que = new LinkedList<Integer>();
		visited[cur] = true;
		que.add(cur);
		while(!que.isEmpty()) {
			Integer out = que.poll();
			sb.append(out+" ");
			for(int i=1; i<=N; i++) {
				if(matrix[out][i] && !visited[i]) {
					visited[i] = true;
					que.add(i);
				}
			}
		}
	}

	private static void dfs(int cur) {
		visited[cur] = true;
		sb.append(cur+" ");
		
		for(int i=1; i<=N; i++) {
			if(matrix[cur][i] && !visited[i]) {
				visited[i] = true;
				dfs(i);
			}
		}
	}
}
