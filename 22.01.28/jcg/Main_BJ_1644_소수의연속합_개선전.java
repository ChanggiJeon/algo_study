import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_1644_소수의연속합_개선전 {
	static boolean[] isDecimal;
	static int[] Primes;
	static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		isDecimal = new boolean[N+1];
		Arrays.fill(isDecimal, true);
		isDecimal[0] = false;
		isDecimal[1] = false;
		
		Prime(); //소수들 구하기.
		System.out.println(Count());
		
		

	}

	private static int Count() {
		int ans = 0;
		int start = Primes.length-1;
		
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
		int j=2;
		while(j*j<=N) {
			for(int i=j; i<=N; i++) {
				if(isDecimal[i] && i!=j && i%j==0) {
					isDecimal[i] = false;
				}
			}
			j++;
			while(!isDecimal[j]) {
				j++;
			}
		}
		
		int cnt = 0;
		for(int i=0; i<=N; i++) {
			if(isDecimal[i])cnt++;
		}
		Primes = new int[cnt];
		cnt = 0;
		for(int i=0; i<=N; i++) {
			if(isDecimal[i]) {
				Primes[cnt++] = i;
			}
		}
	}
}
