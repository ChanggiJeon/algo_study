import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_6087_레이저통신 {
	
	static class Lazor implements Comparable<Lazor>{
		int r, c;
		int dir;
		int mirrorCnt;
		public Lazor(int r, int c, int dir, int mirrorCnt) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.mirrorCnt = mirrorCnt;
		}
		@Override
		public int compareTo(Main_BJ_6087_레이저통신.Lazor o) {
			return this.mirrorCnt - o.mirrorCnt;
		}
	}

	static char[][] map;
	static int R,C;
	static int[][] mirror;
	static int visited[][][];
	static int[] mr = {-1,0,1,0};
	static int[] mc = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new int[R][C][4];
		mirror = new int[2][2];
		int idx = 0;
		
		for(int i=0; i<R; i++) {
			String input = br.readLine();
			for(int j=0; j<C; j++) {
				char info = input.charAt(j);
				if(info == 'C') {
					mirror[idx][0] = i;
					mirror[idx][1] = j;
					idx++;
				}
				Arrays.fill(visited[i][j], 10000);
				map[i][j] = info;
			}
		}
		
		int ans = bfs(mirror[0][0], mirror[0][1]);
		System.out.println(ans);
	}

	
	private static int bfs(int r, int c) {
		PriorityQueue<Lazor> que = new PriorityQueue<>();
		for(int d=0; d<4; d++) {
			int nr = r+mr[d];
			int nc = c+mc[d];
			if(boundary(nr, nc)) {				
				que.add(new Lazor(r,c,d,0));
				visited[r][c][d] = 0;
			}
		}
		
		while(!que.isEmpty()) {
			Lazor o = que.poll();
			if(o.r == mirror[1][0] && o.c == mirror[1][1]) {
				return o.mirrorCnt;
			}
			for(int d=0; d<4; d++) {
				if(Math.abs(o.dir - d) == 2) continue;
				int nr = o.r + mr[o.dir];
				int nc = o.c + mc[o.dir];
				if(boundary(nr,nc) 
						&& map[nr][nc]!='*'
						&& visited[nr][nc][d] > o.mirrorCnt) {
					if(o.dir == d) {
						visited[nr][nc][d] = o.mirrorCnt;
						que.add(new Lazor(nr,nc,d,o.mirrorCnt));
					}else {
						visited[nr][nc][d] = o.mirrorCnt+1;
						que.add(new Lazor(nr,nc,d,o.mirrorCnt+1));
					}
				}
			}
		}
		
		return -1;
	}
	
	private static boolean boundary(int r, int c) {
		return r < R && r>=0 && c < C && c>=0;
	}
}
