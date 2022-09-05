import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_13903_출근 {

	static class Cordinate implements Comparable<Cordinate>{
		int r, c;
		int cnt;

		public Cordinate(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Main_BJ_13903_출근.Cordinate o) {
			return this.cnt - o.cnt;
		}
	}
	
	static int R, C, N;
	static int[][] map;
	static boolean[][] visited;
	static int[] mr;
	static int[] mc;
	static PriorityQueue<Cordinate> pq = new PriorityQueue<Main_BJ_13903_출근.Cordinate>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(i == 0 && map[i][j] == 1) {
					pq.add(new Cordinate(i, j, 0));
					visited[i][j] = true;
				}
			}
		}
		
		N = Integer.parseInt(br.readLine());
		mr = new int[N];
		mc = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			mr[i] = Integer.parseInt(st.nextToken());
			mc[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = simulation();
		System.out.println(ans);
	}

	private static int simulation() {
		
		while(!pq.isEmpty()) {
			Cordinate o = pq.poll();
			if(o.r == R-1) {
				return o.cnt;
			}
			for(int d=0; d<N; d++) {
				int nr = o.r + mr[d];
				int nc = o.c + mc[d];
				if(boundary(nr,nc) && !visited[nr][nc] && map[nr][nc] == 1) {
					pq.add(new Cordinate(nr, nc, o.cnt+1));
					visited[nr][nc] = true;
				}
			}
		}
		return -1;
	}

	private static boolean boundary(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<R && nc<C;
	}

}
