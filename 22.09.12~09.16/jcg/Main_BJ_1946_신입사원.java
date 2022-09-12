import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_BJ_1946_신입사원 {
	/**
	 * 
	 * 1. PriorityQueue -> 1772ms
	 * 2. 단순 index -> 888ms
	 * 
	 * PQ에 넣고 순위 재조정 때문에 시간이 많이 늘어남.
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] rank = new int[N+1];
			
			for(int i=1; i<=N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int o = Integer.parseInt(st.nextToken());
				rank[r] = o;
			}
			
			int cnt = 1;
			int order = rank[1];
			for(int i=2; i<=N; i++) {
				if(rank[i] < order) {
					order = rank[i];
					cnt++;
				}
			}
			sb.append(cnt+"\n");
		}
		
		System.out.print(sb);
	}
	
	
//	static class Applicant implements Comparable<Applicant>{
//		int first; 
//		int second;
//
//		public Applicant(int first, int second) {
//			super();
//			this.first = first;
//			this.second = second;
//		}
//
//		@Override
//		public int compareTo(Main_BJ_1946_신입사원.Applicant o) {
//			return this.first - o.first;
//		}
//	}

//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int T = Integer.parseInt(br.readLine());
//		
//		for(int t=1; t<=T; t++) {
//			int N = Integer.parseInt(br.readLine());
//			int ans = 1;
//			PriorityQueue<Applicant> pq = new PriorityQueue<Main_BJ_1946_신입사원.Applicant>();
//			
//			for(int i=0; i<N; i++) {
//				StringTokenizer st = new StringTokenizer(br.readLine());
//				int f = Integer.parseInt(st.nextToken());
//				int s = Integer.parseInt(st.nextToken());
//				pq.add(new Applicant(f, s));
//			}
//			
//			int order = pq.poll().second;
//			while(!pq.isEmpty()) {
//				Applicant o = pq.poll();
//				if(o.second < order) {
//					order = o.second;
//					ans++;
//				}
//			}
//			sb.append(ans+"\n");
//		}
//		
//		System.out.println(sb);
//	}
}
