import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_15992_123더하기7 {
	static final int F = 1_000_000_009;
	static long[][] DP = new long[1001][1001];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		DP[1][1] = 1;
		DP[2][1] = 1;
		DP[2][2] = 1;
		DP[3][1] = 1;
		DP[3][2] = 2;
		DP[3][3] = 1;
		
		for(int i=4; i<=1000; i++) {
			for(int j=i/3; j<=i; j++) {
				DP[i][j] = (DP[i-1][j-1] + DP[i-2][j-1] + DP[i-3][j-1])%F;
			}
		}
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			sb.append(DP[n][m]+"\n");
		}
		System.out.println(sb.toString().trim());
		
	}

}
