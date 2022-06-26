import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_145000_테트로미노 {
	static class XY{
		int r;
		int c;
		public XY(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static int N, M, max; 
	static int[] mr = {1,0,-1,0};
	static int[] mc = {0,1,0,-1};
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer t = new StringTokenizer(br.readLine());
		N = Integer.parseInt(t.nextToken());
		M = Integer.parseInt(t.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited[i][j] = true;
				dfs(i, j, 1,map[i][j]);
				visited[i][j] = false;
			}
		}
		System.out.println(max);
	}

	private static void dfs(int r, int c, int cnt, int sum) {
		if(cnt ==4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int d=0; d<4; d++) {
			int nr = r+mr[d];
			int nc = c+mc[d];
			if(nr>=0&&nr<N &&nc>=0 &&nc<M&& !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc, cnt+1, sum+map[nr][nc]);
				visited[nr][nc] = false;
			}
		}
		if(cnt==1) {
			int fsum = sum;
			int fcnt = 0;
			for(int d=0; d<4; d++) {
				int nr = r+mr[d];
				int nc = c+mc[d];
				if(nr>=0&&nr<N &&nc>=0 &&nc<M) {
					fsum += map[nr][nc];
					fcnt++;
				}
			}
			if(fcnt==3) max = Math.max(max, fsum);
			else if(fcnt==4) {
				for(int d=0; d<4; d++) {
					int nr = r+mr[d];
					int nc = c+mc[d];
					max = Math.max(max, fsum-map[nr][nc]);
				}
			}
		}
	}
	
}
