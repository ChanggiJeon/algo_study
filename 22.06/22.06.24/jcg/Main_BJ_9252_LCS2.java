import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BJ_9252_LCS2 {
	/**
	 * 참고 : https://velog.io/@emplam27/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B7%B8%EB%A6%BC%EC%9C%BC%EB%A1%9C-%EC%95%8C%EC%95%84%EB%B3%B4%EB%8A%94-LCS-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Longest-Common-Substring%EC%99%80-Longest-Common-Subsequence
	 * 1단계 LCS - Longest Common Subsequence
	 * 2단계 LCS - Longest Common Substring
	 * 최대 숫자를 구하고 나서 다시 찾아가는 것도 힘들었음.
	 * DP 채우는 방식을 역으로 생각해서 찾아야함.
	 *
	 */
	static class XY{
		int r, c;

		public XY(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String first = br.readLine(), second = br.readLine();
		int flength = first.length(), slength = second.length();
		int DP[][] = new int[flength+1][slength+1];
		
		int max = 0;
		int r = 0, c = 0;
		for(int i=1; i<=flength; i++) {
			for(int j=1; j<=slength; j++) {
				if(first.charAt(i-1)==second.charAt(j-1)) {
					DP[i][j] = DP[i-1][j-1]+1;
					if(DP[i][j] > max) {
						max = DP[i][j];
						r = i;
						c = j;
					}
				}else {
					DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		System.out.println(max);
		
		if(max != 0) {
			Queue<XY> que = new LinkedList<Main_BJ_9252_LCS2.XY>();
			que.add(new XY(r,c));
			while(!que.isEmpty()) {
				XY o = que.poll();
				if(o.r < 1 || o.c < 1) {
					break;
				}
				if(first.charAt(o.r-1)==second.charAt(o.c-1)) {
					sb.append(first.charAt(o.r-1));
					que.add(new XY(o.r-1, o.c-1));
				}else {
					if(DP[o.r][o.c]==DP[o.r-1][o.c]) {
						que.add(new XY(o.r-1, o.c));
					}else {
						que.add(new XY(o.r, o.c-1));
					}
				}
			}
		}
		System.out.println(sb.reverse().toString());
	}
}
