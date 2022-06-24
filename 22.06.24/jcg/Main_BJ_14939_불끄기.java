import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_14939_불끄기 {
	/**
	 * 
	 * 2차원 flag관리는 자리수 초과 이슈로 힘듬!
	 * visited[][]쓰자!!
	 * 
	 */
	static boolean[][] map = new boolean[10][10];
	static int[] mr = {-1,1,0,0};
	static int[] mc = {0,0,-1,1};
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<10; i++) {
			String line = br.readLine();
			for(int j=0; j<10; j++) {
				if(line.charAt(j)=='#') {
					map[i][j] = false;
				}else {
					map[i][j] = true;
				}
			}
		}
		combination(0,0,new boolean[10][10],0);
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}
	private static void combination(int cnt, int r, boolean[][]visited, int start) {
		if(r == 10) {
			boolean check = false;
			for(int i=0; i<10; i++) {
				if(map[r-1][i]) {
					check = true;
					break;
				}
			}
			if(!check) {
				min = Math.min(min, cnt);
			}
			return;
		}
		for(int i=start; i<10; i++) {
			//벌써 스위치를 눌렀거나 위쪽이 0이면 패스
			if(visited[r][i] || check(r, i)) {
				continue;
			}
			switching(r,i);
			visited[r][i] = true;
			combination(cnt+1,r, visited,i+1);
			switching(r,i);
			visited[r][i] = false;
		}
		
		if(r>=1) {
			for(int i=0; i<10; i++) {
				if(map[r-1][i]) {
					return;
				}
			}
		}
		combination(cnt, r+1, visited, 0);
	}
	private static void switching(int r, int c) {
		map[r][c] = !map[r][c];
		
		for(int d=0; d<4; d++) {
			int nr = r + mr[d];
			int nc = c + mc[d];
			if(boundary(nr,nc)) {
				map[nr][nc] = !map[nr][nc];
			}
		}
	}
	private static boolean boundary(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<10 && nc<10;
	}
	
	private static boolean check(int r, int c) {
		if(r>=1 && !map[r-1][c]) {
			return true;
		}
		return false;
	}

}
