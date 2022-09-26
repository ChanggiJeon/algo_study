import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_18352_특정거리의도시찾기 {
	
	static class Node{
		int number;
		Node next;
		public Node(int number, Main_BJ_18352_특정거리의도시찾기.Node next) {
			super();
			this.number = number;
			this.next = next;
		}
		
	}

	static int N, M, K, X;
	static int[] distance;
	static Node[] roads;
	static final int INF = 100_000_000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		distance = new int[N+1];
		roads = new Node[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			roads[from] = new Node(to, roads[from]);
		}
		
		boolean[] visited = new boolean[N+1];
		Arrays.fill(distance, INF);
		distance[X] = 0;
		int min = 0, cur = 0;
		for(int i=0; i<N; i++) {
			min = INF;
			for(int j=1; j<=N; j++) {
				if(!visited[j] && distance[j] < min) {
					min = distance[j];
					cur = j;
				}
			}
			if(min > K) {
				break;
			}
			visited[cur] = true;
			
			for(Node n = roads[cur]; n!=null; n=n.next) {
				if(!visited[n.number] && distance[n.number] > min + 1) {
					distance[n.number] = min + 1;
				}
			}
		}
		boolean flag = false;
		for(int i=1; i<=N; i++) {
			if(distance[i] == K) {
				sb.append(i+"\n");
				flag = true;
			}
		}
		if(!flag) {
			System.out.println(-1);
		}else {
			System.out.println(sb);
		}
	}
}
