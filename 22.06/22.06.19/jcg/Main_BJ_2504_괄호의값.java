import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ_2504_괄호의값 {

	/**
	 *  둘다 어렵다. 스택 문제 연습 필요!
	 *  1. 2개 스택 활용하면서 중위표현식으로 만들기 -> 후위표현식으로 계산
	 *  2. 규칙 찾아서 계산.
	 *  (()[[]]) = 2*(2+(3*3))
	 */
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> sign = new Stack<Character>();
		String input = br.readLine();
		int ans = 0;
		int temp = 1;
		for(int i=0; i<input.length(); i++) {
			char cur = input.charAt(i);
			switch(cur) {
				case '(':
					temp *= 2;
					sign.push(cur);
					break;
				case '[':
					temp *= 3;
					sign.push(cur);
					break;
				case ')':
					if(sign.isEmpty() || sign.peek()!='(') {
						System.out.println(0);
						System.exit(0);
					}else if(input.charAt(i-1)=='(') {
						ans += temp;
					}
					sign.pop();
					temp /= 2;
					break;
				case ']':
					if(sign.isEmpty() || sign.peek()!='[') {
						System.out.println(0);
						System.exit(0);
					}else if(input.charAt(i-1)=='[') {
						ans += temp;
					}
					sign.pop();
					temp /= 3;
					break;
			}
		}
		if(!sign.isEmpty()) {
			System.out.println(0);
		}else {
			System.out.println(ans);
		}
	}

}
