import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ_2504_괄호의값 {
	/**
	 * (()[[]])([]) 식을 분석해보면,
	 * 2*2 + 2*3*3 + 2*3 +이 된다.
	 * ( ( ) ( [ [ ] ( [ ]
	 * 괄호가 처음 닫힐때 ans에 더해주고
	 * 열릴때는 sub에 각각 곱하고 닫힐때는 나눠서 원상복귀 시켜준다.
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<Character> stack = new Stack<Character>();
		int ans = 0;
		int sub = 1;
		
		for(int i=0; i<input.length(); i++) {
			char k = input.charAt(i);
			
			if(k == '(') {
				sub *= 2;
				stack.add(k);
			}else if(k == '[') {
				sub *= 3;
				stack.add(k);
			}else if(k == ')') {
				if(stack.isEmpty() || stack.peek() != '(') {
					System.out.println(0);
					System.exit(0);
				}else if(i>0 && input.charAt(i-1)=='(') {
					ans += sub;
				}
				stack.pop();
				sub /= 2;
			}else if(k == ']') {
				if(stack.isEmpty() || stack.peek() != '[') {
					System.out.println(0);
					System.exit(0);
				}else if(i>0 && input.charAt(i-1)=='[') {
					ans += sub;
				}
				stack.pop();
				sub /= 3;
			}
			
		}
		if(!stack.isEmpty()) {
			System.out.println(0);
		}else {
			System.out.println(ans);
		}
	}
}
