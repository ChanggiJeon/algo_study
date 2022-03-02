import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * 주의점
 * 1. 출발지점이 도착지점보다 작을때는 알고리즘 필요없음!
 * 2. 방문확인 잘하자!(visited = true 당연히 한줄 알고 30분 날림)
 *
 */
public class Main_BJ_13913_숨바꼭질4 {
	static class Human implements Comparable<Human>{
		int position, cnt;
		StringBuilder sb;

		public Human(int position, int cnt, StringBuilder sb) {
			super();
			this.position = position;
			this.cnt = cnt;
			this.sb = sb;
		}


		@Override
		public int compareTo(Main_BJ_13913_숨바꼭질4.Human o) {
			return this.cnt-o.cnt;
		}
	}
	static int N, K;
	static boolean visited[] = new boolean[100001];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(N>K) {
			StringBuilder sb = new StringBuilder();
			for(int i=N; i>=K; i--) {
				sb.append(i+" ");
			}
			System.out.println(N-K);
			System.out.println(sb);
		}else {
			go();
		}

	}

	private static void go() {
		PriorityQueue<Human> q = new PriorityQueue<Main_BJ_13913_숨바꼭질4.Human>();
		q.add(new Human(N,0, new StringBuilder(N+" ")));
		
		visited[N] = true;
		while(!q.isEmpty()) {
			Human o = q.poll();
			if(o.position == K) {
				System.out.println(o.cnt);
				System.out.println(o.sb);
				break;
			}
			int np = o.position+1;
			if(boundary(np) && !visited[np] && o.position<K) {
				q.add(new Human(np, o.cnt+1, new StringBuilder(o.sb).append(np+" ")));
				visited[np] = true;
			}
			np = o.position-1;
			if(boundary(np) && !visited[np]) {
				q.add(new Human(np, o.cnt+1, new StringBuilder(o.sb).append(np+" ")));
				visited[np] = true;
			}
			np = o.position*2;
			if(boundary(np) && !visited[np] && o.position<K) {
				q.add(new Human(np, o.cnt+1, new StringBuilder(o.sb).append(np+" ")));
				visited[np] = true;
			}
			
			
		}
	}
 
	private static boolean boundary(int np) {
		return np>=0 && np<=100000;
	}
}
