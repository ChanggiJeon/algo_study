import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_15654_N과M {
	static int[] number, pick;
	static int N, M;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		number = new int[N];
		pick = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(number);
		
		Permutation(0,0);
		System.out.println(sb);
	}

	private static void Permutation(int cnt, int flag) {
		if(cnt >= M) {
			for(int i=0; i<M; i++) {
				sb.append(pick[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if((flag&1<<i)!=0) continue;
			pick[cnt] = number[i];
			Permutation(cnt+1, flag|1<<i);
		}
		
	}

}
