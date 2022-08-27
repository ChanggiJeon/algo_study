import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_10974_모든순열 {

	static int N;
	static int[] pick;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pick = new int[N];
		permutation(0,0);
		System.out.print(sb);
	}

	private static void permutation(int cnt, int flag) {

		if(cnt == N) {
			for(int i=0; i<N; i++) {
				sb.append(pick[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=1; i<=N; i++) {
			if((flag&1<<i)!=0) continue;
			else {
				pick[cnt] = i;
				permutation(cnt+1, flag|1<<i);
			}
		}
	}

}
