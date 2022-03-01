import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_7562_나이트의이동 {
	static class Knight{
		int r,c;
		int cnt;

		public Knight(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	static int N, R, C;
	static Knight[][] map;
	static boolean[][] visited;
	static int[] mr = {-2,-1,-2,-1,2,1,2,1};
	static int[] mc = {-1,-2,1,2,1,2,-1,-2};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int t=1; t<=tc; t++) {
			N = Integer.parseInt(br.readLine());
			map = new Knight[N][N];
			visited = new boolean[N][N];
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			sb.append(findMinMove(r,c)+"\n");
		}
		System.out.println(sb);
		
		
	}

	private static int findMinMove(int r, int c) {
		Queue<Knight> q = new LinkedList<>();
		q.add(new Knight(r, c, 0));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Knight o = q.poll();
			if(o.r==R && o.c==C) {
				return o.cnt;
			}
			for(int d=0; d<8; d++) {
				int nr = o.r+mr[d];
				int nc = o.c+mc[d];
				if(boundary(nr,nc) && !visited[nr][nc]) {
					q.add(new Knight(nr, nc, o.cnt+1));
					visited[nr][nc] = true;
				}
			}
			
		}
		return -1;
		
	}

	private static boolean boundary(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<N && nc<N;
	}
}
