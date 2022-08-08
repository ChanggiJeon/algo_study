package 지하학;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_16931_겉넓이구하기 {
	
	static int R, C;
	static int[][] map;
	static int[] mr = {0,0,1,-1};
	static int[] mc = {1,-1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				ans += countArea(i,j);
				 
			}
		}
		System.out.println(ans);
	}

	private static int countArea(int r, int c) {
		int cnt = 0;
		for(int d=0; d<4; d++) {
			int nr = r + mr[d];
			int nc = c + mc[d];
			if(boundary(nr,nc)) {
				if(map[r][c] - map[nr][nc] > 0) {
					cnt += map[r][c] - map[nr][nc];
				}
			}else {
				cnt += map[r][c];
			}
		}
		//위 + 아래 추가
		return cnt+2;
	}

	private static boolean boundary(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<R && nc<C;
	}

}
