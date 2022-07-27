import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_11725_트리의부모찾기 {
	/**
	 * 
	 * 이진트리로 풀기 -> 이진트리라는 언급이 없어서 X
	 * 2중 for문 -> 시간초과
	 * BFS -> 636ms
	 * DFS -> 812ms
	 * 
	 * DFS보다는 BFS가 조금 더 빠름.(스택 호출에 파라미터 변수를 넘기면서 속도가 느려지는듯)
	 *
	 */
	
	static class Node {
		int num;
		Node next;
		
		public Node(int num, Main_BJ_11725_트리의부모찾기.Node next) {
			super();
			this.num = num;
			this.next = next;
		}
	}
 
	static Node[] list;
	static int[] parent;
	static boolean[] isFixed;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		list = new Node[N+1];
		parent = new int[N+1];
		isFixed = new boolean[N+1];
		
		for(int i=1; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a] = new Node(b, list[a]);
			list[b] = new Node(a, list[b]);
		}
		
//		isFixed[1] = true;
//		parent[1] = 1;
//		dfs(1,list[1]);
		
		isFixed[1] = true;
		parent[1] = 1;
		Queue<Integer> que = new LinkedList<Integer>();
		for(Node n=list[1]; n!=null; n=n.next) {
			if(!isFixed[n.num]) {
				parent[n.num] = 1;
				isFixed[n.num] = true;
				que.add(n.num);
			}
		}
		
		while(!que.isEmpty()) {
			int o = que.poll();
			for(Node n=list[o]; n!=null; n=n.next) {
				if(!isFixed[n.num]) {
					parent[n.num] = o;
					isFixed[n.num] = true;
					que.add(n.num);
				}
			}
		}
		
		for(int i=2; i<=N; i++) {
			sb.append(parent[i]+"\n");
		}
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}

	private static void dfs(int root, Main_BJ_11725_트리의부모찾기.Node node) {
		
		for(Node n=list[root]; n!=null; n=n.next) {
			if(!isFixed[n.num]) {
				isFixed[n.num] = true;
				parent[n.num] = root;
				dfs(n.num, list[n.num]);
			}
		}
		
	}

}
