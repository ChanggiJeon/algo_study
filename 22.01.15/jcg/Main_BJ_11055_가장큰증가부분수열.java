import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11055_가장큰증가부분수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int[] list = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] DP = list.clone();
		DP[0] = list[0];
		for(int i=1; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(list[j]<list[i] && DP[j]+list[i]>DP[i]) {
					DP[i] = DP[j]+list[i];
				}
			}
		}
		
		int max = 0;
		for(int i=N-1; i>=0; i--) {
			if(DP[i]>max) max = DP[i];
		}
		System.out.println(max);
		
	}

}
