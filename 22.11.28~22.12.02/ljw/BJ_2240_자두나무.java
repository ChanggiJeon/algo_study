package A202211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2240_자두나무 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[][] dp = new int[t][w+1];
		int a = Integer.parseInt(br.readLine());
		dp[0][0] = a == 1 ? 1 : 0; 
		dp[0][1] = a == 2 ? 1 : 0;
		int cnt = 0;
		for(int i = 1 ; i < t; i++) {
			int loc = Integer.parseInt(br.readLine());
			dp[i][0] = dp[i-1][0] + (loc == 1 ? 1 : 0);
			for(int j = 1; j <= i+1 && j <= w; j++) {
				if(j % 2 == 0) {
					dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + (loc == 1 ? 1 : 0);
				}else {
					dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + (loc == 2 ? 1 : 0);
				}
			}
		}
		int max = 0;
		for(int n : dp[t-1]) {
			max = Math.max(max, n);
		}
		System.out.println(max);
	}

}
