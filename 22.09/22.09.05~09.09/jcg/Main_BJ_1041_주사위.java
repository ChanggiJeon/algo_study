import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1041_주사위 {
	
	static long min1 = Integer.MAX_VALUE;
	static long min2 = Integer.MAX_VALUE;
	static long min3 = Integer.MAX_VALUE;
	static long max, sum, ans;
	static long[] dice = new long[6];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//idx+3 하면 붙을 수 없는 면이 되게끔 입력을 받는다.
		dice[0] = Integer.parseInt(st.nextToken());
		dice[1] = Integer.parseInt(st.nextToken());
		dice[2] = Integer.parseInt(st.nextToken());
		dice[5] = Integer.parseInt(st.nextToken());
		dice[4] = Integer.parseInt(st.nextToken());
		dice[3] = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<6; i++) {
			sum += dice[i];
			if(max < dice[i]) {
				max = dice[i];
			}
			if(min1 > dice[i]) {
				min1 = dice[i];
			}
		}
		//min2, min3 찾기
		combination(0,0,0, new long[3]);
		
		if(N == 1) {
			ans = sum - max;
		//그리디 방식 해결
		}else {
			ans = (4*min3) + (4 * (N-2) * min2 + 4 * (N-1) * min2) + ((N-2)*(N-2)*min1 + 4*(N-1)*(N-2)*min1);
		}
		System.out.println(ans);
	}

	private static void combination(int start, int cnt, int flag, long[] arr) {
		if(cnt == 3) {
			long sum = 0;
			long max = Math.max(arr[0], arr[1]);
			max = Math.max(max, arr[2]);
			
			for(int i=0; i<3; i++) {
				sum += arr[i];
			}
			if(sum < min3) {
				min3 = sum;
			}
			if((sum-max) < min2) {
				min2 = sum-max;
			}
		}
		
		for(int i=start; i<6; i++){
			//idx+3한 값이 선택되어있다면 붙지 못하므로 pass
			if((flag&1<<((i+3)%6))!=0) continue;
			arr[cnt] = dice[i];
			combination(i+1, cnt+1, flag|1<<i, arr);
		}
	}
}
