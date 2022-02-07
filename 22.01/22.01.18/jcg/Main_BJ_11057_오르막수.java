import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_11057_오르막수 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] DP = new int[2][10];
		Arrays.fill(DP[0], 1);
		for(int i=2; i<=N; i++) {
			for(int j=0; j<=9; j++) {
				int sum = 0;
				for(int k=0; k<=j; k++) {
					sum += DP[i%2][k];
				}
				DP[(i+1)%2][j] = sum%10007;
			}
		}
		int ans = 0;
		for(int i=0; i<=9; i++) {
			ans += DP[(N+1)%2][i];
		}
		System.out.println(ans%10007);
	}

}
