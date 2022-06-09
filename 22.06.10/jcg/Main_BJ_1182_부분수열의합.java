import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1182_부분수열의합 {
	/**
	 * 어우.. 재활치료가 심각하게 필요...
	 * 1. 크기가 양수인 부분수열 -> 아무것도 안고르는 경우 제외
	 */
	static int[] numbers;
	static int N;
	static int S;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		subSet(0, 0, 0);
		System.out.println(ans);
	}

	public static void subSet(int cnt, int sum, int pick) {
	
		if(cnt == N) {
			if(sum == S && pick != 0) {
				ans++;
			}
			return;
		}
		
		subSet(cnt+1, sum+numbers[cnt], pick+1);
		subSet(cnt+1, sum, pick);
	}

}
