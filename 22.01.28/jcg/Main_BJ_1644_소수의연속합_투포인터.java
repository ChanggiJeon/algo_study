import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_1644_소수의연속합_개선 {
	static boolean[] isDecimal;
	static int[] Primes;
	static int N, idx;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		isDecimal = new boolean[N+1];
		Primes = new int[N+1];
		isDecimal[0] = true;
		isDecimal[1] = true;
		
		Prime(); //소수들 구하기.
		System.out.println(Count());
		
		

	}

	private static int Count() {
		int ans = 0;
		int start = idx-1;
		
		while(start>=0) {
			int sum = 0;
			for(int j=start; j>=0; j--) {
				sum += Primes[j];
				if(sum == N) {
					ans++;
					break;
				}else if(sum > N) {
					break;
				}
			}
			start --;
		}
		return ans;
	}

	private static void Prime() {
		for(int i=2; i<N+1; i++) {
			if(!isDecimal[i]) {
				Primes[idx++] = i;
			}
			for(int j=i*2; j<N+1; j=j+i) {
				isDecimal[j] = true;
			}
		}
	}
}
