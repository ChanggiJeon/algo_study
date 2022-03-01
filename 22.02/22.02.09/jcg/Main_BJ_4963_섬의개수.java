import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_4963_섬의개수 {
	static class XY {
		int r;
		int c;

		public XY(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int[][] map;
	static boolean[][] visited;
	static int r, c;
	static int[] mr = { 0, 0, 1, -1 , 1, -1, -1, 1};
	static int[] mc = { 1, -1, 0, 0, 1, -1, 1, -1};

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			if (r == 0 && c == 0)
				break;

			map = new int[r][c];
			visited = new boolean[r][c];

			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < c; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = getIsland();
			sb.append(cnt+"\n");
		}
		System.out.println(sb);

	}

	private static int getIsland() {
		int cnt = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					isConnected(i, j);
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void isConnected(int h, int w) {
		Queue<XY> que = new LinkedList<>();
		que.add(new XY(h, w));
		while (!que.isEmpty()) {
			XY o = que.poll();
			int r = o.r;
			int c = o.c;
			
			for (int d = 0; d < 8; d++) {
				int nr = r + mr[d];
				int nc = c + mc[d];
				if(boundaray(nr,nc) && !visited[nr][nc] && map[nr][nc]==1) {
					que.add(new XY(nr,nc));
					visited[nr][nc] = true;
				}
			}

		}

	}

	private static boolean boundaray(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<r && nc<c;
	}
}
