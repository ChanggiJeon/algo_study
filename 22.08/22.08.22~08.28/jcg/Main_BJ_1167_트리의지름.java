import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1167_트리의지름 {
	/**
	 * 
	 * 정점 1개를 선택한다. -> 선택된 정점을 고정시키고 트리를 추욱 늘여트린다.
	 * 고정 된 root로 부터 가장 멀리 떨어져 있는 정점을 찾는다.
	 * 찾은 정점으로 부터 가장 멀리 떨어져 있는 정점을 찾으면 트리의 가장 긴 길이를 알 수 있다.
	 *
	 */
	static class Node{
		int number, distance;
		Node next;
		
		public Node(int number, int distance, Main_BJ_1167_트리의지름.Node next) {
			super();
			this.number = number;
			this.distance = distance;
			this.next = next;
		}
	}
	
	static int N, max;
	static Node[] nodeList;
	static boolean[] visited;
	static int[] length;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nodeList = new Node[N+1];
		visited = new boolean[N+1];
		length = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			while(true) {
				int num = Integer.parseInt(st.nextToken());
				if(num == -1) {
					break;
				}
				int dis = Integer.parseInt(st.nextToken());
				nodeList[start] = new Node(num, dis, nodeList[start]);
			}
		}
		
		visited[1] = true;
		dfs(1, 0);
		int leaf = 0;
		int max = 0;
		
		for(int i=1; i<=N; i++) {
			if(max < length[i]) {
				leaf = i;
				max = length[i];
			}
		}
		Arrays.fill(visited, false);
		
		visited[leaf] = true;
		dfs(leaf,0);
		for(int i=1; i<=N; i++) {
			if(max < length[i]) {
				max = length[i];
			}
		}
		
		System.out.println(max);
	}

	private static void dfs(int num, int disSum) {
		
		for(Node n = nodeList[num]; n!=null; n=n.next) {
			if(!visited[n.number]) {
				visited[n.number] = true; 
				length[n.number]= disSum + n.distance;
				dfs(n.number, disSum+n.distance);
			}
		}
	}

}
