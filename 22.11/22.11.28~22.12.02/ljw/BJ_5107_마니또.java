package A202211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_5107_마니또 {
	static boolean[] visited;
	static int[][] edge;
	static int N, cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = 0;
		while(true) {
			T++;
			N = Integer.parseInt(br.readLine());
			if(N==0)break;
			Map<String, Integer> names = new HashMap<>();
			edge = new int[N][N];
			visited = new boolean[N];
			int num = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String from = st.nextToken();
				String to = st.nextToken();
				if(!names.containsKey(from))
					names.put(from, num++);
				if(!names.containsKey(to))
					names.put(to, num++);
				edge[names.get(from)][names.get(to)] = 1;
			}
			cnt = 0;
			for(int i = 0; i < N; i++) {
				if(visited[i])continue;
				visited[i]=true;
				for(int j = 0; j < N; j++) {
					if(!visited[j]&&edge[i][j]==1) {
						dfs(j);
					}
				}
			}
			sb.append(T+" "+cnt+"\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int from) {
		visited[from] = true;
		for(int to = 0; to < N; to++) {
			if(edge[from][to]==1) {
				if(visited[to]) cnt++;
				else dfs(to);
				return;
			}
		}
	}
}
