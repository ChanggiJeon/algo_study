package A202209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_5557_1학년 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[][]dp = new long[N][21];
		dp[1][Integer.parseInt(st.nextToken())] = 1;
		for(int i = 2 ; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			for(int k = 0; k <= 20; k++) {
				if(dp[i-1][k]==0) continue;
				int plus = k+now;
				int minus = k-now;
				if(plus <= 20) dp[i][plus]+=dp[i-1][k];
				if(minus >= 0) dp[i][minus]+=dp[i-1][k];
			}
		}
		System.out.println(dp[N-1][Integer.parseInt(st.nextToken())]);
	}
}
