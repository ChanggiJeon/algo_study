import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1958_LCS3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		String M = br.readLine();
		String K = br.readLine();
		
		int[][][] DP = new int[N.length()+1][M.length()+1][K.length()+1];
		for(int i=1; i<=N.length(); i++) {
			for(int j=1; j<=M.length(); j++) {
				for(int k=1; k<=K.length(); k++) {
					if(N.charAt(i-1) == M.charAt(j-1) && M.charAt(j-1) == K.charAt(k-1)) {
						DP[i][j][k] = DP[i-1][j-1][k-1] + 1;
					}else {
						DP[i][j][k] = Math.max(DP[i-1][j][k], Math.max(DP[i][j-1][k], DP[i][j][k-1]));
					}
				}
			}
		}
		
		System.out.println(DP[N.length()][M.length()][K.length()]);
	}

}
