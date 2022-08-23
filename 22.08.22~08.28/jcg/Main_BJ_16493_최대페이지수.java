import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_16493_최대페이지수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] days = new int[M+1];
		int[] pages = new int[M+1];
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			days[i] = Integer.parseInt(st.nextToken());
			pages[i] = Integer.parseInt(st.nextToken());
		}
//		int[][] DP = new int[M+1][N+1];
//		for(int i=1; i<=M; i++) {
//			for(int j=0; j<=N; j++) {
//				if(days[i]<=j) {
//					DP[i][j] = Math.max(DP[i-1][j], DP[i-1][j-days[i]]+pages[i]);
//				}else {
//					DP[i][j] = DP[i-1][j];
//				}
//			}
//		}
		//sliding window
		int[] DP = new int[N+1];
		for(int i=1; i<=M; i++) {
			for(int j=N; j>=0; j--) {
				if(days[i]<=j) {
					DP[j] = Math.max(DP[j], DP[j-days[i]]+pages[i]);
				}
			}
		}
		System.out.println(DP[N]);
	}
}
