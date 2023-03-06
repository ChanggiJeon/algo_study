import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_25379_피하자 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long alreadyExist = 0;
		long cnt = 0;
		long moveR = 0;
		long moveL = 0;
		for(int i=1; i<=N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(n%2 == 0) {
				alreadyExist += cnt++;
				moveL += i-1;
				moveR += N-i;
			}
		}
		System.out.println(Math.min(moveR, moveL) - alreadyExist);
	}
}
