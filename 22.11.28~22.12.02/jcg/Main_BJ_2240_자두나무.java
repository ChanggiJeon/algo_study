import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_2240_자두나무 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] jadu = new int[T];
		for(int i=0; i<T; i++) {
			jadu[i] = Integer.parseInt(br.readLine()) - 1;
		}
		
		// T번째에 바꾸는지 안바꾸는지
		int[][] DP = new int[T][W+1];
		DP[0][0] = jadu[0] == 0? 1: 0;
		DP[0][1] = 1 - DP[0][0];

		for(int t=1; t<T; t++) {
			DP[t][0] = DP[t-1][0] + (jadu[t] == 0? 1: 0);
			for(int w=1; w<=W; w++) {
				if(w%2 == 0) {
					DP[t][w] = Math.max(DP[t-1][w-1], DP[t-1][w]) + (jadu[t] == 0? 1: 0);
				}else {
					DP[t][w] = Math.max(DP[t-1][w-1], DP[t-1][w]) + (jadu[t] == 1? 1: 0);
				}
			}
		}
		int max = 0;
		for(int w=0; w<=W; w++) {
			if(max < DP[T-1][w]) {
				max = DP[T-1][w];
			}
		}
		System.out.println(max);
	}
}
