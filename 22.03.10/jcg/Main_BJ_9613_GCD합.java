import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_9613_GCD합 {
	static int n;
	static long sum;
	static int[] list;
	static int[] pick = new int[2];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			list = new int[n];
			sum = 0;
			
			for(int i=0; i<n; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			
			permutation(0,0);
			sb.append(sum+"\n");
		}
		System.out.println(sb);

	}

	private static void permutation(int cnt, int start) {
		if(cnt == 2) {
			sum += GCD(pick[0], pick[1]);
			return;
		}
		
		for(int i=start; i<n; i++) {
			pick[cnt] = list[i];
			permutation(cnt+1, i+1);
		}
	}

	private static int GCD(int a, int b) {
		if(b==0) {
			return a;
		}
		return GCD(b, a%b);
	}
}
