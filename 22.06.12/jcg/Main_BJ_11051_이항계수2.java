import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11051_이항계수2 {
	static int[][] DP = new int[1001][1001];
	static final int T = 10_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for(int i=1; i<=N; i++) {
			DP[i][0] = 1;
			DP[i][i] = 1;
		}
		for(int i=2; i<=N; i++) {
			for(int j=1; j<i; j++) {
				DP[i][j] = (DP[i-1][j-1] + DP[i-1][j]) % T;
			}
		}
		System.out.println(DP[N][K]);
	}

}
