import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_BJ_2866_문자열잘라내기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		char[][] alphabet = new char[N][K];
		StringBuilder[] words = new StringBuilder[K];
		
		for(int i=0; i<K; i++) {
			words[i] = new StringBuilder();
		}
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<K; j++) {
				char c = input.charAt(j);
				alphabet[i][j] = c;
				words[j] = words[j].append(c);
			}
		}
		
		int ans = -1;
		HashSet<String> set = new HashSet<>();
		o : for(int i=0; i<N; i++) {
			for(int j=0; j<K; j++) {
				if(!set.add(words[j].substring(i))){
					break o;
				}
			}
			set.clear();
			ans ++;
		}
		System.out.println(ans);
	}

}
