import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_15658_연산자끼워넣기2 {
	static int N, MIN, MAX;
	static int[] numberList;
	static int[] signList;
	static int[] signQuantityList = new int[4];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		numberList = new int [N];
		signList = new int [N-1];
		Arrays.fill(signList, -1);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			numberList[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			signQuantityList[i] = Integer.parseInt(st.nextToken());
		}
		
		MIN = Integer.MAX_VALUE;
		MAX = Integer.MIN_VALUE;
		
		findMaxAndMin(0);
		System.out.println(MAX);
		System.out.println(MIN);
	}

	private static void findMaxAndMin(int cnt) {
		if(cnt == N-1) {
			// 현재값, 다음값, 부호 넣어서 계산
			int res = numberList[0];
			for(int i=1; i<N; i++) {
				res = calculate(res, numberList[i], signList[i-1]);
			}
			// 계산된 결과값 MIN, MAX 비교
			if(res<MIN) {
				MIN = res;
			}
			if(res>MAX) {
				MAX = res;
			}
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(signQuantityList[i]<1) {
				continue;
			}
			signQuantityList[i]--;
			signList[cnt] = i;
			findMaxAndMin(cnt+1);
			signQuantityList[i]++;
			signList[cnt] = -1;
		}
	}

	private static int calculate(int cur, int next, int sign) {
		switch(sign) {
			case 0:
				return cur + next;
			case 1:
				return cur - next;
			case 2:
				return cur * next;
			case 3:
				return cur / next;
		}
		return Integer.MAX_VALUE;
	}
}
