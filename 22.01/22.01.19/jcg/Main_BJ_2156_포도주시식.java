import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_2156_포도주시식 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] amount = new int[N];
		for(int i=0; i<N; i++) {
			amount[i] = Integer.parseInt(br.readLine());
		}
		int[][] DP = new int[N][3];
		
		DP[0][1] = amount[0];
		
		for(int i=1; i<N; i++) {
			DP[i][0] = Math.max(DP[i-1][0], DP[i-1][1]);
			DP[i][0] = Math.max(DP[i][0], DP[i-1][2]);
			DP[i][1] = Math.max(DP[i-1][0]+amount[i], DP[i-1][1]);
			DP[i][2] = Math.max(DP[i-1][1]+amount[i], DP[i-1][2]);
		}
		int max = 0;
		for(int i=0; i<3; i++) {
			if(max<DP[N-1][i]) max = DP[N-1][i];
		}
		System.out.println(max);

	}

}
