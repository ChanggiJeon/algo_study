import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_14395_4연산 {

	static class Operation implements Comparable<Operation>{
		long cur;
		String sign;
		public Operation(long cur, String sign) {
			super();
			this.cur = cur;
			this.sign = sign;
		}
		@Override
		public int compareTo(Main_BJ_14395_4연산.Operation o) {
			if(this.sign.length() == o.sign.length()) {
				return this.sign.compareTo(o.sign);
			}
			return this.sign.length() - o.sign.length();
		}
	}
	
	static boolean [] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		visited = new boolean[goal+1];
		if(start == goal) {
			System.out.println("0");
		}else {
			String ans = bfs(start, goal);
			System.out.println(ans);			
		}
	}
	
	private static String bfs(long start, long goal) {
		PriorityQueue<Operation> pq = new PriorityQueue<>();
		pq.add(new Operation(start, ""));
		pq.add(new Operation(1, "/"));
		visited[1] = true;
		if(start <= goal) {
			visited[(int)start] = true;			
		}
		
		while(!pq.isEmpty()) {
			Operation o = pq.poll();
			if(o.cur == goal) {
				return o.sign.toString();
			}
			if(o.cur * o.cur <= goal && !visited[(int)o.cur * (int)o.cur]) {
				pq.add(new Operation(o.cur * o.cur, o.sign + "*"));
				visited[(int)o.cur * (int)o.cur] = true;
			}
			if(o.cur * 2 <= goal && !visited[(int)o.cur*2]) {
				pq.add(new Operation(o.cur *2, o.sign + "+"));
				visited[(int)o.cur*2] = true;
			}
		}
		return "-1";
	}
}
