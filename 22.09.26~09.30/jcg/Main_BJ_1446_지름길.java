import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_1446_지름길 {

	static class Road implements Comparable<Road>{
		int start, end, diffDis;

		public Road(int start, int end, int diffDis) {
			super();
			this.start = start;
			this.end = end;
			this.diffDis = diffDis;
		}

		@Override
		public int compareTo(Main_BJ_1446_지름길.Road o) {
			if(this.end == o.end) {
				return this.start - o.start;
			}
			return this.end - o.end;
		}
	}
	static int N, D;
	static int[][] shortcut;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		PriorityQueue<Road> pq = new PriorityQueue<Main_BJ_1446_지름길.Road>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int disDiff = Integer.parseInt(st.nextToken());
			pq.add(new Road(start, end, disDiff));
		}
		int[] DP = new int[D+1];
		Arrays.fill(DP, D);
		
		int cur = 0;
		while(!pq.isEmpty()) {
			Road o = pq.poll();
			if(o.end - o.start < o.diffDis || o.end > D) {
				continue;
			}
			cur = DP[o.start];
			if(cur == D) {
				cur = o.start;
			}
			for(int i=o.end; i<=D; i++) {
				if(DP[i] > cur + o.diffDis + (i - o.end)) {
					DP[i] = cur + o.diffDis + (i - o.end);
				}
			}
		}
		
		System.out.println(DP[D]);
	}
}
