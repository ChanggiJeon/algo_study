import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_6603_로또 {
	/**
	 * 13P6 = 13*11*4*3 = 12*11*13 -> 브루트포스 가능.
	 */
	
	static StringBuilder sb = new StringBuilder();
	static int k;
	static int[] numberList;
	static int[] pick = new int[6];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			
			if(k==0) {
				break;
			}
			
			numberList = new int[k];
			for(int i=0; i<k; i++) {
				numberList[i] = Integer.parseInt(st.nextToken());
			}
			permutataion(0,0);
			sb.append("\n");
		}
		System.out.print(sb);
	}

	private static void permutataion(int cnt, int start) {
		if(cnt == 6) {
			for(int i=0; i<6; i++) {
				sb.append(pick[i]+" ");
			}
			sb.append("\n");
			return;
		}

		for(int i=start; i<k; i++) {
			pick[cnt] = numberList[i];
			permutataion(cnt+1, i+1);
		}
	}
}
