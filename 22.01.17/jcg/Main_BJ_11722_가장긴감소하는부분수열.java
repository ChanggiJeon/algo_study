import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_11722_가장긴감소하는부분수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N];
		int[] DP = new int[N];
		Arrays.fill(DP, 1);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(list[j]>list[i] && DP[j]+1>DP[i]) {
					DP[i] = DP[j]+1;
				}
			}
		}
		int ans = 0;
		for(int i=0; i<N; i++) {
			if(ans<DP[i]) ans = DP[i];
		}
		System.out.println(ans);
	}

}
