package A202304;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_17396_백도어 {
	static final long INF = 10000000000L;
	static Node[] nList;
	static boolean[] canGo;
	static long[] vertex;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		nList = new Node[N];
		canGo = new boolean[N];
		vertex = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			if (st.nextToken().equals("0"))
				canGo[i] = true;
		}
		canGo[N - 1] = true;
		int from, to, w;
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			nList[from] = new Node(nList[from], to, w);
			nList[to] = new Node(nList[to], from, w);
		}
		Arrays.fill(vertex, INF);
		vertex[0] = 0;
		dijkstra();
		System.out.println(vertex[N - 1] == INF ? -1 : vertex[N - 1]);
	}

	private static void dijkstra() {
		PriorityQueue<T> pque = new PriorityQueue<>();
		pque.add(new T(0,0));
		while(!pque.isEmpty()) {
			T now = pque.poll();
			if(now.n == N-1) return;
			if (!canGo[now.n]) continue;
			canGo[now.n] = false;
			for(Node node = nList[now.n]; node != null; node = node.next) {
				if(vertex[node.num] > now.d + node.weight) {
					vertex[node.num] = now.d + node.weight;
					pque.add(new T(node.num, vertex[node.num]));
				}
			}
		}
	}
	static class T implements Comparable<T>{
		int n;
		long d;
		public T(int n, long d) {
			this.n = n;
			this.d = d;
		}
		@Override
		public int compareTo(T o) {
			return Long.compare(this.d, o.d);
		}
	}
	static class Node {
		Node next;
		int num;
		int weight;

		public Node(Node next, int num, int weight) {
			this.next = next;
			this.num = num;
			this.weight = weight;
		}
	}
}
