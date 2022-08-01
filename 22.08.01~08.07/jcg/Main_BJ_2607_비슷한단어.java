import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_2607_비슷한단어 {
	/**
	 * 
	 * long 900경 -> N*10^18까지
	 * int 21억 -> N*10^9까지
	 * 첫번째 단어와 비슷한 단어의 갯수를 찾는다.
	 * 1.동일 알파벳, 동일 갯수로 이루어진 경우
	 * 2.알파벳 하나를 더하거나, 빼거나, 교체하여 1번과 같이 나올 경우.
	 * 
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] table = new int[N][26];
		int[] length = new int[N];
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			length[i] = input.length();
			for(int j=0; j<input.length(); j++) {
				int alpha = input.charAt(j)-'A';
				table[i][alpha]++;
			}
		}
		
		int ans = 0;
		int startLenght = length[0];
		
		o : for(int i=1; i<N; i++) {
			//길이가 2이상 차이나면 X
			if(startLenght>length[i]+1 || startLenght<length[i]-1) {
				continue;
			}
			
			int diffAlpha = 0;
			int cnt = 0;
			
			for(int k=0; k<26; k++) {
				//단어 수가 2이상 차이나거나, 이미 2번 교체 했다면 X
				if(table[0][k] > table[i][k]+1 || table[0][k]+1 < table[i][k] || cnt>2) {
					continue o;
				}else if(table[0][k] > table[i][k]) {
					diffAlpha++;
					cnt++;
				}else if(table[0][k] < table[i][k]){
					diffAlpha--;
					cnt++;
				}
			}
			//2번 교체, 차이나는 알파벳 수가 0
			if(cnt==2 && diffAlpha == 0) {
				ans++;
			//0번 교체
			}else if(cnt == 0) {
				ans++;
			//1번 추가 및 삭제
			}else if(cnt == 1 && (diffAlpha==1 || diffAlpha == -1) ) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
