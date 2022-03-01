import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_BJ_1476_날짜계산 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
//		E<=15, S<=28, M<=19
		int e = 1;
		int s = 1;
		int m = 1;
		int cnt = 1;
		for(;;) {
			if(e==E && s==S && m==M) {
				break;
			}
			e = e+1>15? 1: e+1;
			s = s+1>28? 1: s+1;
			m = m+1>19? 1: m+1;
			cnt++;
		}
		System.out.println(cnt);
		
	}

}
