import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2252_줄세우기 {
	static class Node {
		int num;
		Node tall;
		public Node(int num, Main_BJ_2252_줄세우기.Node tall) {
			super();
			this.num = num;
			this.tall = tall;
		}
		
	}
	static boolean[] visited;
	static Node[] nodeList;
	static int[] pre;
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		nodeList = new Node[N+1];
		pre = new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int small = Integer.parseInt(st.nextToken());
			int tall = Integer.parseInt(st.nextToken());
			nodeList[small] = new Node(tall, nodeList[small]);
			pre[tall]++;
		}
		
		getOrder();
		System.out.println(sb);
	}

	private static void getOrder() {
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			if(pre[i] == 0) {
				que.add(i);
			}
		}
		while(!que.isEmpty()) {
			int o = que.poll();
			sb.append(o+" ");
			visited[o] = true;
			
			for(Node n = nodeList[o]; n!=null; n=n.tall) {
				if(!visited[n.num] && n.num!=o) {
					pre[n.num]--;
					if(pre[n.num] == 0) {
						que.add(n.num);
					}
				}
			}
		}
	}
}
