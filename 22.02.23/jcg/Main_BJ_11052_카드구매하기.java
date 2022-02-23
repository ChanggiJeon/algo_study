import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11052_카드구매하기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] DP = new int[N+1];
		DP[0] = 0;
		for(int i=1; i<=N; i++) {
			DP[i] = list[i];
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i >= j && DP[i] < list[j]+DP[i-j]) {
					DP[i] = list[j]+DP[i-j];
				}
			}
		}
		
		System.out.println(DP[N]);

	}

}
