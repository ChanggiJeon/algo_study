package Simulation자료구조;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16234_인구이동 {
	static class XY{
		int r, c;

		public XY(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, L, R;
	static int[][] map;
	static int[] mr = {-1, 0, 1, 0};
	static int[] mc = {0, -1, 0, 1};
	static boolean[][] visited;
	static int[][] isLinked;
	static int[] sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(move());
	}

	private static int move() {
		int cnt = 0;
		
		while(true) {
			visited = new boolean[N][N];
			isLinked = new int[N][N];
			sum = new int[1300];
			int count = 1;
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(!visited[r][c] && bfs(r,c, count)) {
						count ++;
					}
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int link = isLinked[i][j];
					if(link != 0) {
						map[i][j] = sum[link];
					}
				}
			}
			
			if(count==1) {
				return cnt;
			}
			cnt++;
		}
		
	}


	private static boolean bfs(int r, int c, int count) {
		Queue<XY> que = new LinkedList<Main_BJ_16234_인구이동.XY>();
		que.add(new XY(r,c));
		visited[r][c] = true;
		boolean isChanged = false;
		int cnt = 1;
		
		while(!que.isEmpty()) {
			XY o = que.poll();
			
			for(int d=0; d<4; d++) {
				int nr = o.r + mr[d];
				int nc = o.c + mc[d];
				if(boundary(nr,nc) && !visited[nr][nc]) {
					int diff = Math.abs(map[o.r][o.c]- map[nr][nc]);
					if(diff>=L && diff<=R) {
						que.add(new XY(nr,nc));
						visited[nr][nc] = true;
						isLinked[nr][nc] = count;
						isLinked[o.r][o.c] = count;
						sum[count] += map[nr][nc];
						cnt ++;
						isChanged = true;
					}
				}
			}
		}
		if(isChanged) {
			sum[count] += map[r][c];
			sum[count] /= cnt;
		}
		return isChanged;
	}

	private static boolean boundary(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<N && nc<N;
	}
}
