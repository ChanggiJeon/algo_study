import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_14002_가장긴증가하는부분수열4 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		//DP배열 생성하고 일단 1개씩 넣기.
		int DP[] = new int[N];
		Arrays.fill(DP, 1);
		
		for(int i=N-1; i>=0; i--) {
			for(int j=i; j<N; j++) {
				if(list[i]<list[j] && DP[i]<DP[j]+1) {
					DP[i]=DP[j]+1;
				}
			}
		}
		int max = 0;
		int idx = 0;
		for(int i=0; i<N; i++) {
			if(DP[i]>max) {
				max = DP[i];
				idx = i;
			}
		}
		//일단 max값 찾고, idx 관리.
		sb.append(max+"\n");
		sb.append(list[idx]+" ");
		
		//list[idx]보다 크고 DP[i]가 1개 줄면, list[i] 취하고 idx 갱신.
		for(int i=idx+1; i<N; i++) {
			if(list[idx]<list[i] && DP[idx] == DP[i]+1) {
				sb.append(list[i]+" ");
				idx = i;
			}
		}
		System.out.println(sb);

	}

}
