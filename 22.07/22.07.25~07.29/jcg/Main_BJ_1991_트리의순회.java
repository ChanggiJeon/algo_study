import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1991_트리의순회 {
	
	/**
	 * 
	 * 2^20 -> 100만
	 * 2^25 -> 3300만
	 * 2^27 -> 1억 초과
	 * 배열로 이진트리 구성 -> int[2^26]으로 메모리 터짐.
	 * 이진트리일 경우, set메소드 구현이 여러모로 유리할 수 있음.
	 *
	 */
	
	static class Node{
		int num;
		Node left;
		Node right;
		
		public Node(int num) {
			super();
			this.num = num;
		}
		
		public void setLeft(Node n) {
			this.left = n;
		}
		
		public void setRight(Node n) {
			this.right = n;
		}
	}
	
	static int N;
	static boolean[] visited;
	static Node[] list;
	static StringBuilder pre = new StringBuilder();
	static StringBuilder in = new StringBuilder();
	static StringBuilder post = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		list = new Node[N];
		StringTokenizer st;

		for(int i=0; i<N; i++) {
			list[i] = new Node(i);
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int root = st.nextToken().charAt(0)-'A';
			char l = st.nextToken().charAt(0);
			char r = st.nextToken().charAt(0);
			if(l != '.') {
				int left = l-'A';
				list[root].setLeft(list[left]);
			}
			if(r != '.') {
				int right = r-'A';
				list[root].setRight(list[right]);
			}
		}
		
		dfs(0);
		
		System.out.println(pre);
		System.out.println(in);
		System.out.println(post);
	}

	private static void dfs(int num) {
		
		pre.append((char)(num+'A'));
		if(list[num].left!=null) {
			dfs(list[num].left.num);
		}
		in.append((char)(num+'A'));
		if(list[num].right!=null) {
			dfs(list[num].right.num);
		}
		post.append((char)(num+'A'));
	}

}
