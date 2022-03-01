import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_2309_일곱난쟁이 {
	static int[] list = new int[9];
	static int[] pick = new int[7];
	static int[] ans = new int[7];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		check(0,0);
	}

	private static void check(int cnt, int flag) {
		if(cnt==7) {
			int sum = 0;
			for(int i=0; i<7; i++) {
				sum += pick[i];
			}
			if(sum==100) {
				ans = pick.clone();
				Arrays.sort(ans);
				for(int i=0; i<7; i++) {
					sb.append(ans[i]+"\n");
				}
				System.out.println(sb);
				System.exit(0);
			}
			return;
		}
		for(int i=0; i<9; i++) {
			if((flag&1<<i)!=0) continue;
			pick[cnt] = list[i];
			check(cnt+1, flag|1<<i);
		}
	}
}
