
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_5639_이진검색트리 {
	static class Tree{
		Node root;
		
		public void makeNode(int n) {
			//1. 루트가 비어있다면 루트에 박제.
			if(this.root == null) {
				this.root = new Node(n);
			//2. 아니라면 자기 위치 찾아가야 함.
			}else {
				searchNode(root, n);
			}
		}

		private void searchNode(Main_BJ_5639_이진검색트리.Node cur, int n) {
			//n이 더 크면? -> 오른쪽 노드에 넣어야 함.
			if(cur.number<n) {
				//비어있다면 바로 넣고.
				if(cur.right == null) {
					cur.right = new Node(n);
					return;
				//안 비어있다면 오른쪽으로 계속 타고 들어가서 비어있는 곳 찾아야함.
				}else {
					searchNode(cur.right, n);
				}
			}else {
				if(cur.left == null) {
					cur.left = new Node(n);
					return;
				}else {
					searchNode(cur.left, n);
				}
			}
		}
	}
	
	static class Node {
		Node left, right;
		int number;
		
		public Node(int number) {
			super();
			this.number = number;
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	static Tree tree = new Tree();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String num = br.readLine();
			if(num == null) break;
			tree.makeNode(Integer.parseInt(num));
		}
		
		treeSearch(tree.root);
		System.out.println(sb);
	}

	private static void treeSearch(Node cur) {
		if(cur.left != null) {
			treeSearch(cur.left);
		}
		if(cur.right != null) {
			treeSearch(cur.right);
		}
		sb.append(cur.number+"\n");
	}
}
