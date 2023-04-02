package A202302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1946_신입사원 {
	static class Score implements Comparable<Score>{
		int A;
		int B;
		public Score(int A, int B) {
			this.A = A;
			this.B = B;
		}
		@Override
		public int compareTo(Score o) {
			return this.A - o.A;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		PriorityQueue<Score> pQue = new PriorityQueue<>();
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());				
				pQue.add(new Score(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			int rank = N+1;
			int cnt = 0;
			while(!pQue.isEmpty()) {
				Score now = pQue.poll();
				if(rank > now.B) { //살아남았다
					rank = now.B;
					cnt++;
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}

}







