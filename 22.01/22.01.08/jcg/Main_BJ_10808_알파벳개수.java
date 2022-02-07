import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_10808_알파벳개수 {
	static int[] alphabet = new int[26];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line = br.readLine();
		for(int i=0; i<line.length(); i++) {
			alphabet[line.charAt(i)-'a']++;
		}
		for(int i=0; i<26; i++) {
			sb.append(alphabet[i]+" ");
		}
		System.out.println(sb);
	}
}
