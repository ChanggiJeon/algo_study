import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_Bj_17299_오등큰수 {
	static class num{
		int idx, num;

		public num(int num, int idx) {
			super();
			this.num = num;
			this.idx = idx;
		}
		
	}
	static int[] count = new int[1000001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int[] number = new int[N];
		int[] ans = new int[N];
		Arrays.fill(ans, -1);
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(st.nextToken());
			number[i] = n;
			count[n]++;
		}
		
		Stack<num> stack = new Stack<num>();
		
		for(int i=0; i<N; i++) {
			int put = count[number[i]];
			while(!stack.isEmpty() && stack.peek().num < put) {
				num o = stack.pop();
				ans[o.idx] = number[i];
			}
			stack.push(new num(put, i));
		}
		
		for(int i=0; i<N; i++) {
			sb.append(ans[i]+" ");
		}
		System.out.println(sb);
	}

}
