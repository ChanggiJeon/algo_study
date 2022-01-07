import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_9093_단어뒤집기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int tc = Integer.parseInt(st.nextToken());
		for(int t=1; t<=tc; t++) {
			st = new StringTokenizer(br.readLine());
			Stack<Character> stack = new Stack();
			while(st.hasMoreTokens()) {
				String next = st.nextToken();
				for(int j=0; j<next.length(); j++) {
					stack.push(next.charAt(j));
				}
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	
	}
}
