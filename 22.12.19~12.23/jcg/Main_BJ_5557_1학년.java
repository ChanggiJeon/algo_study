import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_5557_1학년 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] DP = new long[N][21];
		int[] number = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			number[i] =Integer.parseInt(st.nextToken());
		}
		DP[0][number[0]] = 1;
		
		for(int i=1; i<N-1; i++) {
			for(int j=0; j<=20; j++) {
				if(j+number[i]<=20) {
					DP[i][j] += DP[i-1][j+number[i]];
				}
				if(j-number[i]>=0) {
					DP[i][j] += DP[i-1][j-number[i]];
				}
			}
		}
		System.out.println(DP[N-2][number[N-1]]);
	}
}
