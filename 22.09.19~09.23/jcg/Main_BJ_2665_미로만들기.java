import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_2665_미로만들기 {

	static class XY implements Comparable<XY>{
		int r, c;
		int cnt ;
		public XY(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Main_BJ_2665_미로만들기.XY o) {
			return this.cnt - o.cnt;
		}
	}
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] mr = {0,1,0,-1};
	static int[] mc = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		
		bfs(0,0);
		System.out.println(0);
	}
	
	private static void bfs(int r, int c) {
		PriorityQueue<XY> que = new PriorityQueue<Main_BJ_2665_미로만들기.XY>();
		que.add(new XY(r,c,0));
		visited[0][0] = true;
		
		while(!que.isEmpty()) {
			XY o = que.poll();
			if(o.r == N-1 && o.c == N-1) {
				System.out.println(o.cnt);
				System.exit(0);
			}
			for(int d=0; d<4; d++) {
				int nr = o.r + mr[d];
				int nc = o.c + mc[d];
				if(boundary(nr,nc) && !visited[nr][nc]) {
					if(map[nr][nc] == 1) {
						que.add(new XY(nr,nc,o.cnt));
					}else {
						que.add(new XY(nr,nc,o.cnt+1));
					}
					visited[nr][nc] = true;
				}
			}
		}
		
	}
	private static boolean boundary(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < N;
	}
}
