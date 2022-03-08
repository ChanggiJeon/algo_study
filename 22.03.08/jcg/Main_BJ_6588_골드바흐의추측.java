import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_6588_골드바흐의추측 {
	/**
	 * 
	 * 에라토스테네스의 체 매번 까먹으니 종종 복습하자!
	 * for(int n = integer.parseInt(br.readLine()); n!=0){
	 * 으로 for문 돌리면, 무한 루프 돈다. 다음 n값도 readLine()으로 읽어와야함.
	 * 
	 */
	static boolean[] prime = new boolean[1000001];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		getPrime();
		
		for(int n = Integer.parseInt(br.readLine()); n!=0; n = Integer.parseInt(br.readLine())){
			sb.append(n + " = ");
			for (int i = 2; i < n; i++) {
				if (!prime[i] && !prime[n - i]) {
					if (n - i > i) {
						sb.append(i + " + " + (n - i) + "\n");
						break;
					} else {
						sb.append((n - i) + " + " + i + "\n");
						break;
					}
				}
			}
		}
		System.out.println(sb);

	}

	private static void getPrime() {
		prime[0] = prime[1] = true;
		int n = 1000000;
		
		for(int i=2; i*i<=n; i++) {
			if(!prime[i]) {
				for(int j=i*i; j<=n; j+=i) {
					prime[j] = true;
				}
			}
		}
	}

}
