import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ_1874_스택수열 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(0);
		
		int cnt = 1;
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			while(stack.peek()<num) {
				if(cnt>num) {
					System.out.println("NO");
					System.exit(0);
				}
				stack.push(cnt++);
				sb.append("+\n");
			}
			while(stack.peek()==num) {
				stack.pop();
				sb.append("-\n");
			}
		}
		System.out.println(sb);
	}
}
