import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_10974_모든순열 {
	static int n;
	static int[] pick;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		pick = new int[n];

		
		Permutation(0,0);
		System.out.println(sb);
	}

	private static void Permutation(int cnt, int flag) {
		if(cnt>=n) {
			for(int i=0; i<n; i++) {
				sb.append(pick[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if((flag&1<<i)!=0) continue;
			pick[cnt] = i;
			Permutation(cnt+1, flag|1<<i);
		}
		
	}

}
