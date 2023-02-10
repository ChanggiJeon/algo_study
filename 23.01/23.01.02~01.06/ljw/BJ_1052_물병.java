package A202301;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1052_물병 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		while(m-->0) {
			int tmp = 1;
			while(tmp < n) {
				tmp*=2;
			}
			if(tmp==n) {
				System.out.println(0);
				return;
			}
			if(m==0) {
				System.out.println(tmp-n);
				return;
			}
			tmp/=2;
			n-=tmp;
		}
	}

}
