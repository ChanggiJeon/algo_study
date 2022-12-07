import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1759_암호만들기 {

	static int L, C;
	static char[] list, pick;
	static boolean[] isVowel;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		list = new char[C];
		pick = new char[L];
		isVowel = new boolean[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			list[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(list);
		for(int i=0; i<C; i++) {
			char in = list[i];
			if(checkVowel(in)) {
				isVowel[i] = true;
			}
		}
		
		Subset(0,0);
		System.out.print(sb);
	}

	private static boolean checkVowel(char in) {
		return in == 'a' || in == 'e' || in == 'i' || in == 'o' || in == 'u';
	}

	private static void Subset(int start, int cnt) {
		if(cnt == L) {
			int vowel = 0;
			int con = 0;
			for(int i=0; i<L; i++) {
				if(checkVowel(pick[i])) {
					vowel++;
				}else {
					con++;
				}
			}
			if(vowel >=1 && con >=2) {
				for(int j=0; j<L; j++) {
					sb.append(pick[j]);
				}
				sb.append("\n");
			}
			return;
		}
		for(int i=start; i<C; i++) {
			pick[cnt] = list[i];
			Subset(i+1, cnt+1);
		}
		
	}

}
