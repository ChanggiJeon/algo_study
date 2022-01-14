import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1676_팩토리얼0의개수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int count = 0;
		for(int i=1; i<=N; i++) {
			int l = i;
			while(l%5==0) {
				count++;
				l/=5;
			}
		}
		System.out.println(count);

	}
}
