import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_10820_문자열분석 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line;

		while ((line = br.readLine()) != null) {
			char[] charArray = line.toCharArray();
			int[] count = new int[4];

			for (int i = 0; i < charArray.length; i++) {
				char cur = charArray[i];
				if (cur < 48) {
					count[3]++;
				} else if (cur < 65) {
					count[2]++;
				} else if (cur < 97) {
					count[1]++;
				} else {
					count[0]++;
				}
			}

			sb.append(count[0] + " " + count[1] + " " + count[2] + " " + count[3] + "\n");
		}
		
		System.out.println(sb);
	}
}
