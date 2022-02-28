import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 노트에 map[1][4], map[3][5]까지 구해보면 점화식이 나온다.
 */

public class Main_BJ_2225_합분해 {
	static long[][] map = new long[201][201];
	static final long K = 1000000000;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=200; i++) {
			map[1][i] = i;
			map[i][1] = 1;
		}
		
		for(int i=2; i<=n; i++) {
			for(int j=2; j<=k; j++) {
				map[i][j] = (map[i-1][j]+map[i][j-1])%K;
			}
		}
		
		System.out.println(map[n][k]%K);
	}

}
