import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_13975_파일합치기3 {
	/**
	 * 
	 * 나중에 직접 heap과 pq를 구현해보자...
	 * 
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=T; t++) {
			int K = Integer.parseInt(br.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<Long>();
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<K; i++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			long ans = 0;
			while(pq.size() != 1) {
				long n = pq.poll();
				long sum = n + pq.poll();
				ans += sum;
				pq.add(sum);
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb);
		
	}
}
