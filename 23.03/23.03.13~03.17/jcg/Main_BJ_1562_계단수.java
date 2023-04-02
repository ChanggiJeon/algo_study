import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_1562_계단수 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long DP[][][] = new long[N+1][10][1<<10];
		int DIV = 1_000_000_000;
		
		// 첫 자리는 1 ~ 9까지 - 0이 될 수 없다.
		for(int k=1; k<10; k++) {
			DP[1][k][1<<k] = 1;
		}
		
		// 두번째 자리부터 N번째 자리까지 체우기
		for(int i=2; i<=N; i++) {
			// 들어올 수 있는 숫자는 0~9
			for(int k=0; k<10; k++) {
				// 이전 단계의 모든 경우의 수를 더해준다.
				for(int f=1; f<1<<10; f++) {
					// 현재 방문 경우의수 f에 k번째를 추가 방문 체크해줌
					int visited = f | 1<<k;
					// 선택한 수가 0이라면, 이전 수는 1만 가능.(계단수)
					if(k==0) {
						DP[i][k][visited] += DP[i-1][1][f] % DIV;
					// 선택한 수가 9라면, 이전 수는 8만 가능.
					}else if(k==9) {
						DP[i][k][visited] += DP[i-1][8][f] % DIV;
					}else {
						DP[i][k][visited] += DP[i-1][k-1][f] + DP[i-1][k+1][f] % DIV;
					}
				}
			}
		}
		
		long ans = 0;
		// N번까지 모두 선택 완료 되었다면, 0~9까지 모두 선택한 경우(1<<10)-1 의 숫자들을 모두 더해 출력
		for(int i=0; i<10; i++) {
			ans += DP[N][i][(1<<10) - 1];
			ans %= DIV;
		}
		System.out.println(ans);
	}
}
