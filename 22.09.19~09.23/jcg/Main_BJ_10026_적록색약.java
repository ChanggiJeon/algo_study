import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_10026_적록색약 {
	static class XY{
		int r, c, color;

		public XY(int r, int c, int color) {
			super();
			this.r = r;
			this.c = c;
			this.color = color;
		}
		
	}
	
	static int[] mr = {0,0,1,-1};
	static int[] mc = {1,-1,0,0};
	static boolean[][] visited;
	static char[][] map;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j =0; j<N; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		StringBuilder sb = new StringBuilder();
		
		visited = new boolean[N][N];
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j =0; j<N; j++) {
				if(!visited[i][j]) {
					bfs(i, j, false);
					cnt++;
				}
			}
		}
		sb.append(cnt+" ");
		
		visited = new boolean[N][N];
		cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j =0; j<N; j++) {
				if(!visited[i][j]) {
					bfs(i, j, true);
					cnt++;
				}
			}
		}
		sb.append(cnt);
		System.out.println(sb);
	}

	private static void bfs(int r, int c, boolean flag) {
		Queue<XY> que = new LinkedList<Main_BJ_10026_적록색약.XY>();
		int color = makeColor(map[r][c], flag);
		
		que.add(new XY(r, c, color));
		while(!que.isEmpty()) {
			XY o = que.poll();
			for(int d=0; d<4; d++) {
				int nr = o.r + mr[d];
				int nc = o.c + mc[d];
				if(boundary(nr,nc) && !visited[nr][nc] && o.color == makeColor(map[nr][nc], flag)) {
					que.add(new XY(nr,nc, color));
					visited[nr][nc] = true;
				}
			}
		}
	}

	private static int makeColor(char c, boolean flag) {
		if(!flag && c == 'G') {
			return 1;
		}else if(!flag && c == 'B') {
			return 2;
		}else if(flag && c == 'G') {
			return 0;
		}else if(flag && c == 'B') {
			return 1;
		}
		return 0;
	}

	private static boolean boundary(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}

}
