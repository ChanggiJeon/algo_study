import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11655_ROT13 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line = br.readLine();

		for(int i=0; i<line.length(); i++) {
			int cur = line.charAt(i);
			if(cur>109) {
				sb.append((char)(cur-13));
			}else if(cur>=97){
				sb.append((char)(cur+13));
			}else if(cur>77) {
				sb.append((char)(cur-13));
			}else if(cur>=65){
				sb.append((char)(cur+13));
			}else {
				sb.append((char)(cur+0));
			}
		}
		
		System.out.println(sb);
	}
}
