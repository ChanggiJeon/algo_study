import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16933_벽부수고이동하기3 {
	static class Move implements Comparable<Move> {
		int r, c, turn, cnt;
		boolean day;
		@Override
		public int compareTo(Main_BJ_16933_벽부수고이동하기3.Move o) {
			return this.turn - o.turn;
		}
		public Move(int r, int c, int turn, int cnt, boolean day) {
			super();
			this.r = r;
			this.c = c;
			this.turn = turn;
			this.cnt = cnt;
			this.day = day;
		}
	}

	static int N, M, K;
	static boolean[][] map;
	static int[][][] visited;
	static boolean day;
	static int[] mr = {0,1,0,-1};
	static int[] mc = {1,0,-1,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new boolean[N+1][M+1];
		visited = new int[N+1][M+1][11];
		
		for(int i=1; i<=N; i++) {
			String input = br.readLine();
			for(int j=1; j<=M; j++) {
				map[i][j] = input.charAt(j-1) == '0';
				Arrays.fill(visited[i][j], 100_000);
			}
		}
		
		int ans = simulation();
		System.out.println(ans);
	}

	private static int simulation() {
		PriorityQueue<Move> que = new PriorityQueue<>();
		que.add(new Move(1,1,1,K,true));
		visited[1][1][K] = 1;
		
		while(!que.isEmpty()) {
			Move o = que.poll();
			if(o.r == N && o.c == M) {
				return o.turn;
			}
			for(int d=0; d<4; d++) {
				int nr = o.r + mr[d];
				int nc = o.c + mc[d];
				if(boundary(nr, nc)) {
					if(map[nr][nc] && visited[nr][nc][o.cnt] > o.turn + 1) {
						visited[nr][nc][o.cnt] = o.turn + 1;
						que.add(new Move(nr,nc,o.turn+1, o.cnt, !o.day));
					}else if(!map[nr][nc] && o.cnt > 0) {
						if(o.day && visited[nr][nc][o.cnt]>o.turn+1) {
							visited[nr][nc][o.cnt] = o.turn + 1;
							que.add(new Move(nr,nc,o.turn+1,o.cnt-1,!o.day));
						}else if(!o.day && visited[nr][nc][o.cnt]>o.turn+2) {
							visited[nr][nc][o.cnt] = o.turn + 2;
							que.add(new Move(nr,nc,o.turn+2,o.cnt-1,o.day));
						}
					}
				}
			}
		}
		return -1;
	}

	private static boolean boundary(int nr, int nc) {
		return nr > 0 && nr <= N && nc > 0 && nc <=M;
	}
}
