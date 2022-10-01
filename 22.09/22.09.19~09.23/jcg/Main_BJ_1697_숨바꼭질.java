import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1697_숨바꼭질 {
	
	static class Move implements Comparable<Move> {
		int position;
		int cnt;
		public Move(int position, int cnt) {
			super();
			this.position = position;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Main_BJ_1697_숨바꼭질.Move o) {
			return this.cnt - o.cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[100_001];
		PriorityQueue<Move> que = new PriorityQueue<Main_BJ_1697_숨바꼭질.Move>();
		
		if(start >= goal) {
			System.out.println(start - goal);
		}else {
			que.add(new Move(start, 0));
			while(!que.isEmpty()) {
				Move o = que.poll();
				if(o.position == goal) {
					System.out.println(o.cnt);
					break;
				}
				int d = o.position * 2;
				int mi = o.position - 1;
				int pl = o.position + 1;
				
				if(mi >= 0 && !visited[mi] ) {
					que.add(new Move(mi, o.cnt +1));
					visited[mi] = true;
				}
				if(d <= 100000 && !visited[d]) {
					que.add(new Move(d, o.cnt +1));
					visited[d] = true;
				}
				if(pl <= 100000 && !visited[pl]) {
					que.add(new Move(pl, o.cnt +1));
					visited[pl] = true;
				}
			}
		}
		
	}

}
