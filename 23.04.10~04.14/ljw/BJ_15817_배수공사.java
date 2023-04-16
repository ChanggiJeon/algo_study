package A202304;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15817_배수공사 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[][] pipes = new int[n][2];
		for(int i = 0 ; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			pipes[i][0] = Integer.parseInt(st.nextToken());
			pipes[i][1] = Integer.parseInt(st.nextToken());
		}
		System.out.println(dpFind(n, x, pipes));
	}
	
	public static int dpFind(int n, int x, int[][] pipes) {
        int[] dp = new int[x + 1];
        dp[0] = 1;

        for (int[] pipe : pipes) {
            int length = pipe[0];
            int count = pipe[1];

            for (int j = x; j >= 0; j--) {
                for (int k = 1; k <= count; k++) {
                    if (j - k * length < 0) {
                        break;
                    }
                    dp[j] += dp[j - k * length];
                }
            }
        }

        return dp[x];
    }
	
}
