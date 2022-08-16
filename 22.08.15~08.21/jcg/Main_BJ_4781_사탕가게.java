import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_4781_사탕가게 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			//여기서 0.29를 100곱하면 28.99999999가 나와서 28로 입력된다.
			int M = (int)(Double.parseDouble(st.nextToken())*100+0.1);
			if(n == 0) break;
			
			int[] calorie = new int[n+1];
			int[] cost = new int[n+1];
			// index 1부터 사용
			for(int i=1; i<=n; i++) {
				st = new StringTokenizer(br.readLine());
				calorie[i] = Integer.parseInt(st.nextToken());
				cost[i] = (int)(Double.parseDouble(st.nextToken())*100+0.1);
			}
			
			int[] DP = new int[M+1];
			
			//사탕은 index 1번부터 n번까지
			for(int i=1; i<=n; i++) {
				//비용은 0원부터 최대 M원까지
				for(int m=0; m<=M; m++) {
					//사탕 여러개 구매 가능. 쪼개기는 불가능
					if(cost[i] <= m) {
						DP[m] = Math.max(DP[m-cost[i]]+calorie[i], DP[m]);
					}
				}
			}
			sb.append(DP[M]+"\n");
		}
		System.out.print(sb);
	}
}
