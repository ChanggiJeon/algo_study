import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_1699_제곱수의합 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] DP = new int[160001];
		Arrays.fill(DP, 10000);
		for(int i=1; i<=400; i++) {
			DP[i*i] = 1;
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=400; j++) {
				int sq = j*j;
				if(i-sq>0) {
					if(DP[i]>DP[i-sq]+1) {
						DP[i]=DP[i-sq]+1;
					}
				}else {
					break;
				}
			}
		}
		System.out.println(DP[N]);
	}

}
