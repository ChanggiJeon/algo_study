import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1535_안녕 {
	/**
	 * 나중에 DP로도 풀어보자...
	 * 
	 */

	static int N, ans;
	static int[] loss, joy;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		loss = new int[N];
		joy = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			loss[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			joy[i] = Integer.parseInt(st.nextToken());
		}
		
		subSet(0,100,0);
		System.out.println(ans);
	}

	private static void subSet(int start, int health, int joySum) {
		for(int i=start; i<N; i++) {
			if(health-loss[i]>0) {
				subSet(i+1, health-loss[i], joySum+joy[i]);
			}
		}
		if(ans<joySum) {
			ans = joySum;
		}
	}
}
