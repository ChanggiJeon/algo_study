import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_15990_123더하기5 {
	static final long D = 1000000009;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long[][] DP = new long[100001][4];
		DP[1][1] = 1;
		DP[2][2] = 1;
		DP[3][1] = 1;
		DP[3][2] = 1;
		DP[3][3] = 1;
		for(int i=4; i<=100000; i++) {
			DP[i][1] = (DP[i-1][2]+DP[i-1][3])%D;
			DP[i][2] = (DP[i-2][1]+DP[i-2][3])%D;
			DP[i][3] = (DP[i-3][1]+DP[i-3][2])%D;
		}
		
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append((DP[N][1]+DP[N][2]+DP[N][3])%D+"\n");
		}
		System.out.println(sb);
	}
}