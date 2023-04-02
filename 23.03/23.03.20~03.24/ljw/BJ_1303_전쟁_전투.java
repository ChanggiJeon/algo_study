package A202302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1303_전쟁_전투 {
	static int[] dy = new int[] {-1,0,1,0};
	static int[] dx = new int[] {0,1,0,-1};
	static boolean[][] visited;
	static char[][] field;
	static Map<Character, List<Integer>> map;
	static int R,C;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		field = new char[R][C];
		visited = new boolean[R][C];
		for(int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < C; j++) {
				field[i][j] = tmp.charAt(j);
			}
		}
		map = new HashMap<>();
		map.put('W', new ArrayList());
		map.put('B', new ArrayList());
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(visited[i][j])continue;
				visited[i][j] = true;
				map.get(field[i][j]).add(dfs(i, j, field[i][j]));
			}
		}
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for(int nm : map.get('W')) {
			cnt += nm * nm;
		}
		sb.append(cnt + " ");
		cnt = 0;
		for(int nm : map.get('B')) {
			cnt += nm * nm;
		}
		sb.append(cnt);
		
		System.out.println(sb);
	}
	private static int dfs(int i, int j, char c) {
		int cnt = 1;
		int ni,nj;
		for(int d = 0; d < 4; d++) {
			ni = i + dy[d];
			nj = j + dx[d];
			if(ni>=0&&ni<R&&nj>=0&&nj<C&&!visited[ni][nj]&&field[ni][nj]==c) {
				visited[ni][nj] = true;
				cnt+=dfs(ni,nj,c);
			}
		}
		return cnt;
	}

}
