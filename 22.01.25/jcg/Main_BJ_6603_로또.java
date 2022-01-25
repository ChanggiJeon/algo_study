import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_6603_로또 {
	static int K;
	static int[] pick, list;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			if(K == 0) break;
			list = new int[K];
			pick = new int[6];
			for(int i=0; i<K; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			Permutation(0,0,0);
			sb.append("\n");
		}
		System.out.println(sb);

	}

	private static void Permutation(int cnt, int start, int flag) {
		if(cnt >= 6) {
			for(int i=0; i<6; i++) {
				sb.append(pick[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<K; i++) {
			if((flag&1<<i)!=0) continue;
			pick[cnt] = list[i];
			Permutation(cnt+1, i+1, flag|1<<i);
		}
		
	}

}
