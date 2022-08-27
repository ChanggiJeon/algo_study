import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14500_테트로미노 {
	
	/**
	 * 
	 * 1. 모든 cnt에서 뒤로가는게 가능하게 하면 -> 2020ms
	 * 2. 모형 생각해보면 cnt==3일때만 뒤로갈 수 있게 설계하면 됨 -> 664ms
	 * 3. 최대 map 2000 사방 탐색 x 4 = 2^9 x 1000 -> 512000 브루트포스
	 * 
	 */
	static int R,C, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] mr = {1,0,-1,0};
	static int[] mc = {0,1,0,-1};
	
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
			}
		}
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				visited[r][c] = true;
				dfs(r,c,1,map[r][c],false);
				visited[r][c] = false;
			}
		}
		System.out.println(ans);
	}

	private static void dfs(int r, int c, int cnt, int sum, boolean back) {
		if(cnt == 4) {
			if(ans<sum) {
				ans = sum;
			}
			return;
		}
		
		if(cnt == 3) {
			for(int d=0; d<4; d++) {
				int nr = r+mr[d];
				int nc = c+mc[d];
				if(boundary(nr,nc)) {
					if(!visited[nr][nc]) {
						visited[nr][nc] = true;
						dfs(nr,nc,cnt+1, sum+map[nr][nc], back);
						visited[nr][nc] = false;
					}else if(!back){
						dfs(nr,nc,cnt,sum, true);
					}
				}
			}
		}else {
			for(int d=0; d<4; d++) {
				int nr = r+mr[d];
				int nc = c+mc[d];
				if(boundary(nr,nc)) {
					if(!visited[nr][nc]) {
						visited[nr][nc] = true;
						dfs(nr,nc,cnt+1, sum+map[nr][nc], back);
						visited[nr][nc] = false;
					}
				}
			}
		}
	}

	private static boolean boundary(int nr, int nc) {
		return nr<R && nc<C && nr>=0 && nc>=0;
	}

}
