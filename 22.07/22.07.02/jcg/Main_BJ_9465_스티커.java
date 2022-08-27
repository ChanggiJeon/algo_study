import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_9465_스티커 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] list = new int[3][N+1];
			for(int i=1; i<=2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++) {
					list[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] DP = new int[3][N+1];
			DP[0][1] = 0;
			DP[1][1] = list[1][1];
			DP[2][1] = list[2][1];
			for(int i=2; i<=N; i++) {
				DP[0][i] = Math.max(DP[1][i-1], DP[2][i-1]);
				DP[1][i] = Math.max(DP[0][i-1]+list[1][i],DP[2][i-1]+list[1][i]);
				DP[2][i] = Math.max(DP[0][i-1]+list[2][i],DP[1][i-1]+list[2][i]);
			}
			int max = Math.max(DP[0][N], DP[1][N]);
			max = Math.max(max, DP[2][N]);
			
			sb.append(max+"\n");
		}
		System.out.println(sb);
	}

}
