import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2178_미로탐색 {
	static class XY {
		int r, c;

		public XY(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] mr = {0, 0, 1, -1};
	static int[] mc = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		int ans = bfs();
		System.out.println(ans);
	}

	private static int bfs() {
		Queue<XY> que = new LinkedList();
		que.add(new XY(0,0));
		visited[0][0] = true;
		int cnt = 0;
		
		while(true) {
			cnt ++;
			int size = que.size();
			for(int i=0; i<size; i++) {
				XY o = que.poll();
				if(o.r == N-1 && o.c == M-1) {
					return cnt;
				}
				for(int d=0; d<4; d++) {
					int nr = o.r + mr[d];
					int nc = o.c + mc[d];
					if(boundary(nr, nc) && !visited[nr][nc] && map[nr][nc]==1) {
						que.add(new XY(nr, nc));
						visited[nr][nc] = true;
					}
				}
			}
		}
	}

	private static boolean boundary(int nr, int nc) {
		return nr<N && nr>=0 && nc<M && nc>=0;
	}
}
