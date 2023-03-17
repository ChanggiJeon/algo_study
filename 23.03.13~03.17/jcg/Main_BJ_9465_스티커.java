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
			int[][] DP = new int[2][N];
			int[][] cost = new int[2][N];
			
			for(int i=0; i<2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					cost[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if(N == 1){
				sb.append(Math.max(DP[0][0], DP[1][0])+"\n");
				continue;
			}
			DP[0][0] = cost[0][0];
			DP[1][0] = cost[1][0];
			DP[0][1] = DP[1][0] + cost[0][1];
			DP[1][1] = DP[0][0] + cost[1][1];
			
			for(int j=2; j<N;j++) {
				for(int i=0; i<2; i++) {
					DP[i][j] = cost[i][j]+Math.max(DP[(1+i)%2][j-1],DP[(1+i)%2][j-2]);
				}
			}
			sb.append(Math.max(DP[0][N-1], DP[1][N-1])+"\n");
		}
		System.out.print(sb);
	}
}
