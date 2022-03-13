import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_1309_동물원 {
	/**
	 * 선택할 수 있는 경우의 수.
	 * 동물을 아예 안 넣거나, 1번칸에 넣거나 2번칸에 넣거나.
	 * 를 고려해서 DP를 생성하면 된다.
	 */
	static final int D = 9901;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] DP = new int[n+1][3];
		DP[1][0] = 1;
		DP[1][1] = 1;
		DP[1][2] = 1;
		
		for(int i=2; i<=n; i++) {
			DP[i][0] = (DP[i-1][0] + DP[i-1][1] + DP[i-1][2])%D;
			DP[i][1] = (DP[i-1][0] + DP[i-1][2])%D;
			DP[i][2] = (DP[i-1][0] + DP[i-1][1])%D;
		}
		int ans = (DP[n][0]+DP[n][1]+DP[n][2])%D;
		System.out.println(ans);
	}

}
