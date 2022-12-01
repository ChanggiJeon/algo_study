import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2468_안전영역 {

	static class XY {
		int r, c;

		public XY(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int[][] map;
	static int N, max, maxDepth, minDepth;
	static int[] mr = {0,0,-1,1};
	static int[] mc = {1,-1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		minDepth = Integer.MAX_VALUE;
		max = 1;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n > maxDepth) {
					maxDepth = n;
				}
				if(n < minDepth) {
					minDepth = n;
				}
				map[i][j] = n;
			}
		}
		
		for(int i=minDepth; i<=maxDepth; i++) {
			int n = countIsland(i);
			if(max < n) {
				max = n;
			};
		}
		System.out.println(max);
	}

	private static int countIsland(int depth) {
		int cnt = 0;
		boolean[][] visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] > depth && !visited[i][j]) {
					bfs(i,j, visited, depth);
					cnt+=1;
				}
			}
		}
		
		return cnt;
	}

	private static void bfs(int r, int c, boolean[][] visited, int depth) {
		Queue<XY> que = new LinkedList<>();
		que.add(new XY(r,c));
		visited[r][c] = true;
		
		while(!que.isEmpty()) {
			XY o = que.poll();
			for(int d=0; d<4; d++) {
				int nr = o.r + mr[d];
				int nc = o.c + mc[d];
				if(boundary(nr,nc) && !visited[nr][nc] && map[nr][nc] > depth) {
					que.add(new XY(nr,nc));
					visited[nr][nc] = true;
				}
			}
		}
	}
	
	private static boolean boundary(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
