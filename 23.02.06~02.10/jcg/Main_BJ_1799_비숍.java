import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1799_비숍 {

	static int N;
	static int[] ans = new int[2];
	static int[] cnt = new int[2];
	static boolean[][] visited;
	static boolean[][] canPlace;
	static int[] mr = {-1, -1};
	static int[] mc = {-1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		visited = new boolean[N][N];
		canPlace = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int input = Integer.parseInt(st.nextToken());
				if(input == 1) {
					canPlace[i][j] = true;
					if((i+j)%2 == 0) cnt[0]++;
					else cnt[1]++;
				}
			}
		}
		dfs(-1, 0, cnt[0], 0);
		dfs(-1, 0, cnt[1], 1);
		
		System.out.println(ans[0] + ans[1]);
	}
	
	private static void dfs(int cur, int sum, int candidate, int color) {
		if(candidate + sum <= ans[color]) return;
		
		ans[color] = Math.max(ans[color], sum);
		
		for(int i=cur+1; i<N*N; i++) {
			int r = i/N;
			int c = i%N;
			if((r+c)%2 != color) continue;
			if(canPlace[r][c]) {
				candidate --;
				if(check(r,c)) {
					visited[r][c] = true;
					dfs(i, sum+1, candidate, color);
					visited[r][c] = false;
				}
			}
		}
		
	}
	private static boolean check(int r, int c) {
		o : for(int d=0; d<2; d++) {
			int nr = r;
			int nc = c;
			for(int k=0; k<=10; k++) {
				nr += mr[d];
				nc += mc[d];
				if(!boundary(nr,nc)) {
					continue o;
				}
				if(visited[nr][nc]) return false;
			}
		}
		return true;
	}
	
	private static boolean boundary(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}
}
