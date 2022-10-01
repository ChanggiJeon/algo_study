package String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_13022_늑대와올바른단어 {
	static char[] words = { 'w', 'o', 'l', 'f' };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int idx = 0;
		int[] cnt = new int[4];
		
		for(int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			if(words[idx] == c) {
				cnt[idx]++;
			}else if(words[(idx+1)%4] == c){
				idx = (idx+1)%4;
				cnt[idx]++;
				if(idx == 2 && cnt[0] != cnt[1]) {
					System.out.println(0);
					System.exit(0);
				}else if(idx == 3 && cnt[1] != cnt[2]) {
					System.out.println(0);
					System.exit(0);
				}else if(idx == 0 && cnt[2] != cnt[3]) {
					System.out.println(0);
					System.exit(0);
				}
			}else {
				System.out.println(0);
				System.exit(0);
			}
		}
		for(int i=0; i<3; i++) {
			if(cnt[i] != cnt[i+1]) {
				System.out.println(0);
				System.exit(0);
			}
		}
		System.out.println(1);
	}
}
