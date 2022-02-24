import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_15988_123더하기3 {
	static final long D = 1000000009;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long[] DP = new long[1000001];
		DP[1] = 1;
		DP[2] = 2;
		DP[3] = 4;
		
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			int N = Integer.parseInt(br.readLine());
			for(int i=4; i<=N; i++) {
				DP[i] = (DP[i-3]+DP[i-2]+DP[i-1])%D;
			}
			sb.append(DP[N]%D+"\n");
		}
		
		System.out.println(sb);

	}

}
