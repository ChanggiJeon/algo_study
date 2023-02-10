import java.util.LinkedList;
import java.util.Queue;

public class Solution_PG_양과늑대 {

	static class Node{
		int idx;
		boolean visited;
		Node left;
		Node right;
		public Node(int idx) {
			super();
			this.idx = idx;
		}
		public void add(Node n) {
			if(this.left == null) {
				this.left = n;
			}else {
				this.right = n;
			}
		}
	}
	static int ans;
	static boolean[] visited;
	static boolean[] exist;
	static Node[] tree;
	static int[] arr;
	static int[] parentIdx;
	
	public static void main(String[] args) {
		arr = new int[] {0,1,0,1,0,1,0,1};
		int[][] edges = {
			{0,1},{1,2},{2,3},{3,4},{0,6},{6,7}
		};
		
		tree = new Node[arr.length];
		visited = new boolean[arr.length];
		exist = new boolean[arr.length];
		parentIdx = new int[arr.length];
		boolean[] visited = new boolean[arr.length];
		ans = 1;
		
		//루트 노드
		tree[0] = new Node(0);
		parentIdx[0] = -1;
		
		//2진 트리 제작
		for(int i=0; i<edges.length; i++) {
			int parents = edges[i][0];
			int child = edges[i][1];
			parentIdx[child] = parents;
			if(tree[child] == null) {
				tree[child] = new Node(child);
			}
			if(tree[parents] == null) {
				tree[parents] = new Node(parents);
			}
			tree[parents].add(tree[child]);
		}
		exist[0] = true;
		dfs(0,1,0,visited);
		System.out.println(ans);
	}

	private static void dfs(int curNode, int sheep, int wolf, boolean[] visited) {
		if(sheep <= wolf) {
			return;
		}
		//부모로 이동 => 이미 거쳐왔을 것이므로 exist는 신경 안써도됨.
		int parent = parentIdx[curNode];
		if(parent!=-1 && !visited[parent]) {
			visited[parent] = true;
			dfs(parent, sheep, wolf, visited);			
		}
		
		// 좌측이동
		if(tree[curNode].left != null) {
			int nextNode = tree[curNode].left.idx;
			if(!visited[nextNode]) {
				//양이나 늑대가 존재하면?
				if(!exist[nextNode]) {
					if(arr[nextNode] == 0 ) {
						exist[nextNode] = true;
						ans = Math.max(ans, sheep+1);
						dfs(nextNode, sheep+1, wolf, new boolean[arr.length]);
						exist[nextNode] = false;
					}else {
						exist[nextNode] = true;
						visited[nextNode] = true;
						dfs(nextNode, sheep, wolf+1, visited);
						exist[nextNode] = false;
					}
				}else {
					visited[nextNode] = true;
					dfs(nextNode, sheep, wolf, visited);
				}
			}
		}
		// 우측이동
		if(tree[curNode].right != null) {
			int nextNode = tree[curNode].right.idx;
			if(!visited[nextNode]) {
				//양이나 늑대가 존재하면?
				if(!exist[nextNode]) {
					if(arr[nextNode] == 0 ) {
						exist[nextNode] = true;
						ans = Math.max(ans, sheep+1);
						dfs(nextNode, sheep+1, wolf, new boolean[arr.length]);
						exist[nextNode] = false;
					}else {
						exist[nextNode] = true;
						visited[nextNode] = true;
						dfs(nextNode, sheep, wolf+1, visited);
						exist[nextNode] = false;
					}
				}else {
					visited[nextNode] = true;
					dfs(nextNode, sheep, wolf, visited);
				}
			}
		}
	}
}
