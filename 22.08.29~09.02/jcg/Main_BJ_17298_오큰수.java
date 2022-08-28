import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_17298_오큰수 {
	
	static class Cordinate{
		int idx;
		int num;
		public Cordinate(int idx, int num) {
			super();
			this.idx = idx;
			this.num = num;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Stack<Cordinate> stack = new Stack<Cordinate>();
		int[] list = new int[N+1];
		int[] result = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		stack.push(new Cordinate(1,list[1]));
		for(int i=2; i<=N; i++) {
			while(!stack.isEmpty() && stack.peek().num<list[i]) {
				Cordinate o = stack.pop();
				result[o.idx] = list[i]; 
			}
			stack.push(new Cordinate(i, list[i]));
		}
		
		while(!stack.isEmpty()) {
			result[stack.pop().idx] = -1;
		}
		
		for(int i=1; i<=N; i++) {
			sb.append(result[i]+" ");
		}
		System.out.println(sb);
	}
}