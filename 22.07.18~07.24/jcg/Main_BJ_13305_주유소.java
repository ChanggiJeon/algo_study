import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_13305_주유소 {

	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long distance[] = new long[N-1];
		long cost[] = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		long ans = 0;
		long curCost = cost[0];
		for(int i=1; i<N; i++) {
			ans += distance[i-1]*curCost;
			if(cost[i]<curCost) {
				curCost = cost[i];
			}
		}
		System.out.println(ans);
	}
}
