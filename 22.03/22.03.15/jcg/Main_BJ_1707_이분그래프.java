import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1707_이분그래프 {
	/**
	 * 
	 * 이분 그래프
	 * 하나의 정점에 1(색깔)을 칠하고
	 * 그 정점과 연결되어있는 모든 정점을 살펴 본다.(색이 안칠해져있으면 반대색 -1로 칠함)
	 * 연결되어있는 정점이 같은 색이 하나라도 있으면 안됨.
	 * 
	 */
	static class Node{
		int num;
		Node next;
		public Node(int num, Main_BJ_1707_이분그래프.Node next) {
			super();
			this.num = num;
			this.next = next;
		}
	}

	static int V, E;
	static Node[] list;
	static int colors[];
	static boolean isBinary;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
	
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			list = new Node[V+1];
			colors = new int[V+1];
			
			for(int i=1; i<=V; i++) {
				list[i] = new Node(i, null);
			}
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from] = new Node(to, list[from]);
				list[to] = new Node(from, list[to]);
			}
			int color = 1;
			isBinary = true;
			
			for(int i=1; i<=V; i++) {
				if(colors[i] == 0) {
					colors[i] = color;
					dfs(i, color);
					if(!isBinary) break;
					color = -color;
				}
			}
			if(isBinary) {
				sb.append("YES\n");
			}else {
				sb.append("NO\n");
			}
			
		}
		System.out.println(sb);
	}

	private static void dfs(int cur, int color) {
		for (Node n = list[cur]; n != null; n = n.next) {
			if (cur != n.num && colors[n.num] == color) {
				isBinary = false;
			}else if(colors[n.num] == 0) {
				colors[n.num] = -color;
				dfs(n.num, -color);
			}
		}
	}
}


