import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_17103_골드바흐파티션 {

	static boolean[] prime = new boolean[1000001];
	static final int N = 1000000;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for(int i=2; i*i<N; i++) {
			if(prime[i]) {
				for(int j=2*i; j<N; j+=i) {
					prime[j] = false;
				}
			}
		}
		
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int cnt = 0;
			for(int i=n; i>=n/2; i--) {
				if(prime[i] && prime[n-i]) {
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
