import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_17298_오큰수 {
	static class num{
		int idx, num;

		public num(int idx, int num) {
			super();
			this.idx = idx;
			this.num = num;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		
		int[] list = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		Stack<num> stack = new Stack<Main_BJ_17298_오큰수.num>();
		
		int[] result = new int[N+1];
		
		stack.push(new num(1,list[1]));
		
		for(int i=2; i<=N; i++) {
			while(!stack.isEmpty() && stack.peek().num < list[i]) {
				num o = stack.pop();
				result[o.idx] = list[i];
			}
			stack.push(new num(i,list[i]));
		}
		
		while(!stack.isEmpty()) {
			num o = stack.pop();
			result[o.idx] = -1;
		}
		
		for(int i=1; i<=N; i++) {
			sb.append(result[i]+" ");
		}
		
		System.out.println(sb);
	}
}
