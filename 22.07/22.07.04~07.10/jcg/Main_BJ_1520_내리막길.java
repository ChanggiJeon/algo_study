import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_1520_내리막길 {
	
	static class XY implements Comparable<XY>{
		 int r, c, cnt;

		public XY(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Main_BJ_1520_내리막길.XY o) {
			return this.cnt - o.cnt;
		}
	}
	
	static int R, C, ans;
	static int[][] map;
	static int[][] DP;
	static int mr[] = {0,0,1,-1};
	static int mc[] = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		DP = new int[R][C];
		for(int i=0; i<R; i++) {
			Arrays.fill(DP[i], -1);
		}
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = dfs(0, 0);
		System.out.println(ans);
	}

	private static int dfs(int r, int c) {
		//도착이라면 1반납.
		if(r == R-1 && c == C-1) {
			return 1;
		}
		//경로 방문 이력이 있다면 경우의 수 반납
		if(DP[r][c]!=-1) {
			return DP[r][c];
		}
		
		int cnt = 0;
		for(int d=0; d<4; d++) {
			int nr = r + mr[d];
			int nc = c + mc[d];
			if(boundary(nr,nc) && map[nr][nc]<map[r][c]) {
				//경로 찾아옴
				cnt += dfs(nr,nc);
			}
		}
		//찾아온 경로 갱신
		DP[r][c] = cnt;
		return DP[r][c];
	}

	private static boolean boundary(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<R && nc<C;
	}
}
