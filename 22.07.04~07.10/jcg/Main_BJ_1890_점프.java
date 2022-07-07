import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1890_점프 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		long[][] DP = new long[N][N];
		DP[0][0] = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				long cnt = DP[i][j];
				int mv = map[i][j];
				if(cnt!=0 && mv!=0) {
					if(i+mv < N) {
						DP[i+mv][j] += cnt;
					}
					if(j+mv < N) {
						DP[i][j+mv] += cnt;
					}
				}
			}
		}
		System.out.println(DP[N-1][N-1]);
	}
}
