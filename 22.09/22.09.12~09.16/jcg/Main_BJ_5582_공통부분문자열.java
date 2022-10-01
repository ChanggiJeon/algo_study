import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_5582_공통부분문자열 {
	/**
	 * 
	 * 처음에 KMP문제인 줄 알았지만, -> 부분 일치 문제
	 * 단순 3중 for문 -> 시간초과
	 * 2중 for 문 + DP -> PASS
	 * 
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		int pl = pattern.length, tl = text.length;
		int[][] DP = new int[tl+1][pl+1];
		
		int ans = 0;
		for(int i=1; i<=tl; i++) {
			for(int j=1; j<=pl; j++) {
				if(text[i-1] == pattern[j-1]) {
					DP[i][j] = Math.max(DP[i-1][j-1]+1, 1);
					if(ans < DP[i][j]) {
						ans = DP[i][j];
					}
				}
			}
		}
		
		System.out.println(ans);
	}
}
