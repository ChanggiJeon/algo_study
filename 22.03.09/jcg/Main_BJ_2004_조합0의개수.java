
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_BJ_2004_조합0의개수 {
	/**
	 * 
	 * n!에서 5의 지수승은 n<5일때까지 n/5를 더해주면 된다.
	 * nCm을 이렇게 (n)으로 표현하는지 몰랐다..
	 * 			  (m)
	 * 
	 */

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());

		int two = (powerTwo(n)-powerTwo(n-m)-powerTwo(m));
		int five = (powerFive(n)-powerFive(n-m)-powerFive(m));
		int ans = Math.min(two, five);
		System.out.println(ans);
	}

	private static int powerFive(long n) {
		int cnt = 0;
		while(n>=5) {
			cnt+= n/5;
			n /= 5;
		}
		return cnt;
	}

	private static int powerTwo(long n) {
		int cnt = 0;
		while(n>=2) {
			cnt+= n/2;
			n /= 2;
		}
		return cnt;
	}

}
