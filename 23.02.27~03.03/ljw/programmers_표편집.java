import java.util.Stack;
class Solution {
    Node select;
	Node[] nodes;
	Stack<Node> stack;
    public String solution(int n, int k, String[] cmd) {
        // TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		nodes = new Node[n];
		stack = new Stack<>();
		for(int i = 0 ; i < n; i++) {
			nodes[i] = new Node(null, null, i);
		}
		
		nodes[0].Right = nodes[1];
		nodes[n-1].Left = nodes[n-2];
		for(int i = 1; i < n-1; i++) {
			nodes[i].Left = nodes[i-1];
			nodes[i].Right = nodes[i+1];
		}
		select = nodes[k];
		for(String str : cmd) {
			switch(str.charAt(0)) {
				case 'U':
					up(Integer.parseInt(str.split(" ")[1]));
					break;
				case 'D':
					down(Integer.parseInt(str.split(" ")[1]));
					break;
				case 'C':
					delete();
					break;
				case 'Z':
					recovery();
			}
		}
		//젤 왼쪽으로
		while(select.Left != null) select = select.Left;
		int cnt = 0;
		while(select != null) {
			if(cnt == select.num) {
				sb.append("O");
				cnt++;
			}
			else {
				for(int i = 0; i < select.num - cnt; i++) {
					sb.append("X");
				}
				sb.append("O");
				cnt = select.num+1;
			}
			select = select.Right;
		}
        for(int i = 0; i < n - cnt; i++) {
            sb.append("X");
        }
		return sb.toString();
    }
    private void recovery() {
        if(stack.size()==0)return;
		Node now = stack.pop();
		if(now.Left != null && now.Right != null) {
			now.Left.Right = now;
			now.Right.Left = now;
		}
		else if (now.Left != null && now.Right == null) {
			now.Left.Right = now;
		}
		else if (now.Left == null && now.Right != null) {
			now.Right.Left = now;
		}
	}
	private void delete() {
		stack.add(select);
		if(select.Left != null && select.Right != null) {
			select.Left.Right = select.Right;//연결 끊기
			select.Right.Left = select.Left;
			select = select.Right;
		}
		else if (select.Left != null && select.Right == null) {
			select.Left.Right = null;//연결 끊기
			select = select.Left;
		}
		else if (select.Left == null && select.Right != null) {
			select.Right.Left = null;//연결 끊기
			select = select.Right;
		}
		
	}
	private void up(int n) {
		while(n-->0) {
			if(select.Left == null) return;
			select = select.Left;
		}
	}
	
	private void down(int n) {
		while(n-->0) {
			if(select.Right == null) return;
			select = select.Right;
		}
	}
    class Node{
		Node Left;
		Node Right;
		int num;
		public Node(Node Left, Node Right, int num) {
			this.Left=Left;
			this.Right=Right;
			this.num=num;
		}
	}
}