import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14499_주사위굴리기 {
	
	static int[][] map;
	static int N, M, r, c;
	static int[][] dice = new int[4][3];
	static int[] mr = {0, 0, 0, -1, 1};
	static int[] mc = {0, 1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		map  = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int t=0; t<T; t++) {
			//1,2,3,4 동 서 북 남
			int order = Integer.parseInt(st.nextToken());
			int nr = r + mr[order];
			int nc = c + mc[order];
			
			if(boundary(nr, nc)) {
				continue;
			}else {
				diceMove(order);
				if(map[nr][nc] != 0) {
					dice[3][1] = map[nr][nc];
					map[nr][nc] = 0;
				}else {
					map[nr][nc] = dice[3][1];
				}
				sb.append(dice[1][1]+"\n");
				r = nr;
				c = nc;
			}
		}
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}

	private static void diceMove(int order) {
		//오른쪽으로 굴렸을 때
		if(order == 1) {
			int temp = dice[1][0];
			for(int i=0; i<2; i++) {
				dice[1][i] = dice[1][i+1];
			}
			dice[1][2] = dice[3][1];
			dice[3][1] = temp;
		//왼쪽으로 굴렸을 때
		}else if(order == 2) {
			int temp = dice[1][2];
			for(int i=2; i>0; i--) {
				dice[1][i] = dice[1][i-1];
			}
			dice[1][0] = dice[3][1];
			dice[3][1] = temp;
		//위쪽으로 굴렸을 때
		}else if(order == 3) {
			int temp = dice[3][1];
			for(int i=3; i>0; i--) {
				dice[i][1] = dice[i-1][1];
			}
			dice[0][1] = temp;
		//아래쪽으로 굴렸을 때
		}else {
			int temp = dice[0][1];
			for(int i=0; i<3; i++) {
				dice[i][1] = dice[i+1][1];
			}
			dice[3][1] = temp;
		}
	}

	private static boolean boundary(int nr, int nc) {
		return nr<0 || nc<0 || nr>=N || nc>=M;
	}
}
