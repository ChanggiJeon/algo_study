import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1149_RGB거리 {

	/**
	 * DP문제 -> 현재 고를 수있는 최선의 수를 누적한다.
	 * 현재 고를 수 있는 경우의 수 -> 빨강 or 초록 or 파랑
	 * DP[i][0] -> i번째(현재) 빨강으로 칠했을 경우 = 
	 * 이전 i-1번째는 초록, 파랑중 비용이 작은 것 칠함 + 현재 빨강의 비용
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int[][] cost = new int[N][3];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int[][] DP = new int[N][3];
		DP[0][0] = cost[0][0];
		DP[0][1] = cost[0][1];
		DP[0][2] = cost[0][2];
		
		for(int i=1; i<N; i++) {
			DP[i][0] = Math.min(DP[i-1][1], DP[i-1][2]) + cost[i][0];
			DP[i][1] = Math.min(DP[i-1][0], DP[i-1][2]) + cost[i][1];
			DP[i][2] = Math.min(DP[i-1][0], DP[i-1][1]) + cost[i][2];
		}
		
		int ans = Math.min(DP[N-1][0], DP[N-1][1]);
		ans = Math.min(ans, DP[N-1][2]);
		System.out.println(ans);
	}
}
