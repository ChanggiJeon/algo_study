import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1463_1로만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] DP = new int[1000001];
		DP[1] = 0;
		DP[2] = 1;
		DP[3] = 1;
		for(int i=4; i<1000001; i++) {
			DP[i] = DP[i-1]+1;
			if(i%3==0) {
				DP[i] = Math.min(DP[i/3]+1, DP[i]);
			}
			if(i%2==0) {
				DP[i] = Math.min(DP[i/2]+1, DP[i]);
			}
		}
		System.out.println(DP[N]);
	}

}
