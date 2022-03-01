import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_1748_수이어쓰기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		for(int i=1; i<=N; i*=10) {
			ans += N - i + 1;
		}
		System.out.println(ans);
		
	}
}
