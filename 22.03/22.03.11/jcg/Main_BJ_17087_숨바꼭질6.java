import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_17087_숨바꼭질6 {
	/**
	 * 
	 * 여러 항목의 최대공약수(GCD)구하는 방법은 
	 * 첫 번째 수를 최대공약수(gcd)로 정하고 
	 * 두 번째 수부터 이전까지의 최대공약수(gcd)와 
	 * 현재 배열의 값(a[i])의 최대공약수를 구하여 다시 gcd에 저장한다. 
	 * 이러한 작업을 마지막까지 반복하면 모든 수의 최대공약수가 구해진다.
	 * 
	 */
	static int[] list;
	static int n, s;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		list = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			list[i] = Math.abs(Integer.parseInt(st.nextToken())-s);
		}
		int gcd = list[0];
		if (n > 1) {
			for (int i = 1; i < n; i++) {
				gcd = GCD(gcd, list[i]);
			}
		}
		System.out.println(gcd);
		
	}

	private static int GCD(int a, int b) {
		if(b==0) {
			return a;
		}
		return GCD(b, a%b);
		
	}

}
