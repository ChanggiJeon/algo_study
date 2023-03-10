import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_1946_신입사원 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] list = new int[N+1];
			
			StringTokenizer st = null;
			int rank = 1_000_000;
			int ans = 0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a] = b;
			}
			
			for(int i=1; i<=N; i++) {
				if(rank > list[i]) {
					rank = list[i];
					ans++;
				}
			}
			sb.append(ans+"\n");
		}
		System.out.print(sb);
	}
}
