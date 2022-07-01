import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1062_가르침 {
	/**
	 * 
	 * 코드 정리는 나중에..
	 */

	static int N, K, ans;
	static boolean[][] words;
	static int[] needWordsCnt;
	static boolean[] check;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new boolean[N][26];
		needWordsCnt = new int[N];
		check = new boolean[26];
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<input.length(); j++) {
				int word = input.charAt(j) - 'a';
				// 입력값이 필수 단어면 패스
				if(necessary(word)) {
					continue;
				}
				// n번째 단어에 필요한 알파벳인지 체크
				if(!words[i][word]) {
					words[i][word] = true;
					//n번째 단어 만들려면 새롭게 필요한 알파벳 갯수 관리
					needWordsCnt[i]++;
				}
				// 해당 알파벳이 필요한지 체크
				check[word] = true;
			}
		}
		int done = 0;
		//필수 알파벳만으로 이미 완성된 단어 확인
		for(int i=0; i<N; i++) {
			if(needWordsCnt[i] == 0) {
				done++;
			}
		}
		// 필수 알파벳 5개 이하면 0, 이상이면 시뮬레이션
		if(K>=5) {
			simulate(0, 1, 0, needWordsCnt.clone(), done);
			System.out.println(ans);
		}else {
			System.out.println(0);
		}
		
	}

	private static void simulate(int cnt, int start, int flag, int[] wordsCnt, int done) {
		//단어 조합에 남은 알파벳 수, 사용할 수 있는 알파벳 수 비교
		int possible = 0;
		for(int i=0; i<N; i++) {
			if(wordsCnt[i]!=0 && wordsCnt[i] <= K-5-cnt) {
				possible++;
			}
		}
		//백트래킹
		if(done+possible <= ans) {
			return;
		}else if(possible == 0) {
			ans = done;
			return;
		}
		
		//모든 단어 다 만들었으면 N출력후 종료
		if(done == N) {
			System.out.println(N);
			System.exit(0);
		}
	
		//배울 수 있는 알파벳 다 배웠으면 몇개 단어 배웠는지 체크
		if(cnt == K-5) {
			int max = 0;
			for(int i=0; i<N; i++) {
				if(wordsCnt[i]==0) {
					max++;
				}
			}
			ans = Math.max(ans, max);
			return;
		}
		
		for(int i=start; i<26; i++) {
			//해당 알파벳이 안쓰이거나, 필수 단어이거나, 사용중이면 continue
			if((flag&1<<i)!=0 || !check[i] || necessary(i)) {
				continue;
			}
			//영단어마다 남은 알파벳 수 관리
			int[] temp = wordsCnt.clone();
			int add = 0;
			for(int n=0; n<N; n++) {
				if(words[n][i]) {
					temp[n]--;
					if(temp[n] == 0) {
						add++;
					}
				}
			}
			simulate(cnt+1, i, flag|1<<i, temp, done+add);
		}
	}

	private static boolean necessary(int i) {
		return i==0 || i==2 || i==8 || i==13 || i==19;
	}
}
