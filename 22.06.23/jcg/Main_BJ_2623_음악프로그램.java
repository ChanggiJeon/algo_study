import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2623_음악프로그램 {
	
	/**
	 * 
	 * 1. 방문체크 필수
	 * 2. 이전 단계 남아있는지 확인
	 * 3. Node 연결 상태 관리
	 *
	 */
	static class Node {
		int num;
		Node head;
		public Node(int num, Main_BJ_2623_음악프로그램.Node head) {
			super();
			this.num = num;
			this.head = head;
		}
	}
	
	static int N, M;
	static Node[] nodeList;
	static boolean[] visited;
	static int[] pre;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nodeList = new Node[N+1];
		visited = new boolean[N+1];
		pre = new int[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			for(int j=0; j<n; j++) {
				int k = Integer.parseInt(st.nextToken());
				arr[j] = k;
			}
			for(int j=0; j<n-1; j++) {
				int cur = arr[j];
				int next = arr[j+1];
				nodeList[cur] = new Node(next, nodeList[cur]);
				pre[next] ++;
			}
		}
		find();
		
		boolean check = false;
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				System.out.println(0);
				check = true;
				break;
			}
		}
		if(!check) {
			System.out.println(sb.toString());
		}
	}

	private static void find() {
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			if(pre[i]==0) {
				que.add(i);
			}
		}

		while(!que.isEmpty()) {
			int o = que.poll();
			visited[o] = true;
			sb.append(o+"\n");
			
			for(Node node = nodeList[o]; node!=null; node=node.head) {
				if(node.num != o && !visited[node.num]) {
					pre[node.num] --;
					if(pre[node.num] == 0) {
						que.add(node.num);
					}
				}
			}
		}
	}
}
