import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_2529_부등호 {
	static char[] sign, number;
	static int k;
	static String min, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		k = Integer.parseInt(br.readLine());
		min = Long.MAX_VALUE+"";
		max = Long.MIN_VALUE+"";
		sign = new char[k];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) {
			sign[i] = st.nextToken().charAt(0);
		}
		number = new char[k+1];
		
		Permutation(0, 0);
		System.out.println(max+"\n"+min);
	}

	private static void Permutation(int cnt, int flag) {
		if(cnt>k) {
			String line = new String(number);
			long num = Long.parseLong(line);
			
			if(Long.parseLong(min)>num) {
				min = line;
			}
			if(Long.parseLong(max)<num) {
				max = line;
			}
			return;
		}
		
		for(int i=0; i<=9; i++) {
			if((flag&1<<i)!=0 || condition(cnt, i)) continue; //사용중인 숫자이거나 조건을 만족하지 못하면 continue
			else{
				number[cnt] = (char)(i+'0');
				Permutation(cnt+1, flag|1<<i);
			}
		}
		
	}

	private static boolean condition(int cnt, int cur) {
		if(cnt==0) return false;
		
		int before = number[cnt-1]-'0';
		if(sign[cnt-1] == '<') {
			if(before>cur) {
				return true;
			}
		}else {
			if(before<cur) {
				return true;
			}
		}
		return false;
	}

}
