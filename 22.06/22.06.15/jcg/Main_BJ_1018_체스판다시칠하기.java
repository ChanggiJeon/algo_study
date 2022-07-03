import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1018_체스판다시칠하기 {

	static int N, M;
	static boolean[][] map;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				if(line.charAt(j)=='W') {
					map[i][j] = true;
				}else {
					map[i][j] = false;
				}
			}
		}
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				simulate(i,j);
			}
		}
		
		System.out.println(ans);
	}

	private static void simulate(int R, int C) {
		int count = 0;
		boolean cur = true;
		for(int i=R; i<R+8; i++) {
			for(int j=C; j<C+8; j++) {
				if(cur != map[i][j]) {
					count ++;
				}
				cur = !cur;
			}
			cur = !cur;
		}

		count = Math.min(count, 64-count);
		ans = Math.min(ans, count);
	}

}
