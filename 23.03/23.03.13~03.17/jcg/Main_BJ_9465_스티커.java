import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_9465_스티커 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] DP = new int[3][N];
			int[][] cost = new int[3][N];
			
			for(int i=1; i<=2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					cost[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			DP[0][0] = 0;
			DP[1][0] = cost[1][0];
			DP[2][0] = cost[2][0];
			
			for(int i=1; i<N; i++) {
				DP[0][i] = Math.max(DP[1][i-1], DP[2][i-1]);
				DP[1][i] = Math.max(DP[0][i-1],DP[2][i-1])+cost[1][i];
				DP[2][i] = Math.max(DP[0][i-1],DP[1][i-1])+cost[2][i];
			}
			
			int ans = Math.max(DP[0][N-1], DP[1][N-1]);
			ans = Math.max(ans, DP[2][N-1]);
			sb.append(ans+"\n");
		}
		System.out.print(sb);
	}
}
