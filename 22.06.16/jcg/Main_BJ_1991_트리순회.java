import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_1991_트리순회 {
	/**
	 * 
	 * 3번 똑같이 방문할 필요 없이,
	 * stringbuilder를 3개 만들면 된다!
	 *
	 */
	
	static class Node{
		char cur;
		char left, right;
		public Node(char cur, char left, char right) {
			super();
			this.cur = cur;
			this.left = left;
			this.right = right;
		}
	}
	static int N;
	static HashMap<Character, Node> nodeList = new HashMap<Character, Main_BJ_1991_트리순회.Node>();
	static StringBuilder pre = new StringBuilder();
	static StringBuilder mid = new StringBuilder();
	static StringBuilder post = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char cur = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			nodeList.put(cur, new Node(cur,left,right));
		}
		dfs('A');
		System.out.println(pre.append("\n").append(mid).append("\n").append(post));
	}

	private static void dfs(char cur) {
		Node currentNode = nodeList.get(cur);
		if(cur == '.') return;
		pre.append(cur);
		dfs(currentNode.left);
		mid.append(cur);
		dfs(currentNode.right);
		post.append(cur);
	}

}