package A202211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12865_평범한배낭 {
	static class Bag{
		int W,V;
		public Bag(int W, int V) {
			this.W = W;
			this.V = V;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Bag[] obs = new Bag[N+1];
		int[] dp = new int[K+1];
		for(int i = 1 ; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			obs[i] = new Bag(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		for(int i = 1; i <= N; i++) {
			int W = obs[i].W;
			int V = obs[i].V;
			for(int j = K; j > 0; j--) {
				if(j>=W) {
					dp[j] = Math.max(dp[j], dp[j-W]+V);
				}
			}
		}
		System.out.println(dp[K]);
	}
}