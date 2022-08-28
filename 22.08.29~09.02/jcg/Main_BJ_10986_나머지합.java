import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_10986_나머지합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] list = new int[N];
		int[] sum = new int[N];
		int[] remain = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			list[i] = Integer.parseInt(st.nextToken()) % M;
		}
		sum[0] = list[0];
		remain[sum[0] % M]++;
		
		for(int i=1; i<N; i++){
			sum[i] = (sum[i-1] + list[i]);
			remain[sum[i] % M]++;
		}
		
		long ans = remain[0];
		for(int i=0; i<M; i++) {
			int n = remain[i];
			ans += (long)n*(n-1)/2;
		}
		
		System.out.println(ans);
	}
}
