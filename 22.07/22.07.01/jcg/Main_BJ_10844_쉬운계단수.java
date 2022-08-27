import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_10844_쉬운계단수 {
	static final int F = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] DP = new int[101][10];
		DP[1][0] = 0;
		for(int i=1; i<10; i++) {
			DP[1][i] = 1;
		}
		for(int i=2; i<=100; i++) {
			DP[i][0] = DP[i-1][1];
			DP[i][9] = DP[i-1][8];
			for(int j=1; j<9; j++) {
				if(DP[i-1][j-1] + DP[i-1][j+1]<0) {
					System.out.println(i+" "+j);
				}
				DP[i][j] = (DP[i-1][j-1] + DP[i-1][j+1])%F;
			}
		}
		int ans = 0;
		for(int i=0; i<10; i++) {
			ans = (ans+ DP[N][i])%F;
		}
		System.out.println(ans);
	}
}
