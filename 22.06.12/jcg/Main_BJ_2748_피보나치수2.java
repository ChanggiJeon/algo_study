import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_2748_피보나치수2 {
	/**
	 * 
	 * 분할정복(행렬 곱)으로 풀면 오히려 더 느림 -> why??
	 * 
	 */
	static StringBuilder sb = new StringBuilder();
	static long[] fibo = new long[91];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		fibo[0] = 0;
		fibo[1] = 1;
		for(int i=2; i<=N; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		System.out.println(fibo[N]);
		
	}
}
