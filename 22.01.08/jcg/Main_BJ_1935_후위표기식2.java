import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_1935_후위표기식2 {
	static class alpha{
		char alph;
		double number;
		
		public alpha(char alph, double number) {
			super();
			this.alph = alph;
			this.number = number;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<alpha> stack = new Stack<alpha>();
		
		String line = br.readLine();
		
		int[] number = new int[N];
		
		for(int i=0; i<N; i++) {
			number[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<line.length(); i++) {
			char o = line.charAt(i);
			if(64<o) {
				stack.push(new alpha(o, number[o-'A']));
			}else {
				alpha next = stack.pop();
				alpha cur = stack.pop();
				switch (o) {
				case '+':
					stack.push(new alpha('$', cur.number+next.number));
					break;
				case '-':
					stack.push(new alpha('$', cur.number-next.number));
					break;
				case '*':
					stack.push(new alpha('$', cur.number*next.number));
					break;
				case '/':
					stack.push(new alpha('$', cur.number/next.number));
					break;
				}
			}
		}
		
		System.out.printf("%.2f",stack.pop().number);
	}
}