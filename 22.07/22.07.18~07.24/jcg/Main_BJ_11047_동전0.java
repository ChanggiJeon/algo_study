import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11047_동전0 {
	/**
	 * 
	 * while 문 돌리면 188ms
	 * 뭉텅이로 계산하면 128ms
	 * 
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coinList = new int[N];
		for(int i=0; i<N; i++) {
			coinList[i] = Integer.parseInt(br.readLine());
		}
		int ans = 0;
		
		for(int i=N-1; i>=0; i--) {
			if(coinList[i]<=K) {
				ans += K/coinList[i];
				K %= coinList[i];
			}
		}
		System.out.println(ans);
	}
}
