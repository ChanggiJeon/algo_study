package A202302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_25379_피하자 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken())%2;
		}
		long odd = 0;
		long ev = 0;
		int cnt = 0;
		for(int i = 0; i < n; i++) {//짝수 왼쪽
			if(arr[i]==1) {
				cnt++;
				continue;
			}
			ev+=cnt;
		}
		cnt = 0;
		for(int i = 0; i < n; i++) {//홀수 왼쪽
			if(arr[i]==0) {
				cnt++;
				continue;
			}
			odd+=cnt;
		}
		System.out.println(Math.min(ev, odd));
	}
}
