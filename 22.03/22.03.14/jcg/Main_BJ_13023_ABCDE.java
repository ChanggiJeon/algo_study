import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_13023_ABCDE {
	/**
	 * 
	 * 문제를 find, union문제인줄 알아서 삽질...
	 * 친구의 친구는 친구가 아니다...
	 * 
	 *
	 */
	static class Node{
		int num;
		Node next;
		public Node(int num, Main_BJ_13023_ABCDE.Node next) {
			super();
			this.num = num;
			this.next = next;
		}
	}

	static int n, m;
	static Node[] nodeList;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nodeList = new Node[n];
		for(int i=0; i<n; i++) {
			nodeList[i] = new Node(i,null);
		}

		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodeList[a] = new Node(b, nodeList[a]);
			nodeList[b] = new Node(a, nodeList[b]);
		}
		for(int i=0; i<m; i++) {
			dfs(i,0,0);
		}
		System.out.println(0);

	}

	private static void dfs(int cur, int cnt, int flag) {
		if(cnt==5) {
			System.out.println(1);
			System.exit(0);
		}
		
		for(Node n=nodeList[cur]; n!=null; n=n.next) {
			if((flag&1<<n.num)!=0) continue;
			dfs(n.num, cnt+1, flag|1<<n.num);
		}
		
	}

}
