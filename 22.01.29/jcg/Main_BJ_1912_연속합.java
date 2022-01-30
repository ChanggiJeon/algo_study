import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1912_연속합 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] list = new int[n];
		for(int i=0; i<n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		int[] DP = new int[n];
		DP[0] = list[0];
		for(int i=1; i<n; i++) {
			if(DP[i-1]>0) {
				DP[i] = DP[i-1]+list[i];
			}else {
				DP[i] = list[i];
			}
		}
		int ans = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			ans = Math.max(ans, DP[i]);
		}
		System.out.println(ans);

	}

}
