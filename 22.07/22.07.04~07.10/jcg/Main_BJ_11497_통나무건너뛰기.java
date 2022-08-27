import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_11497_통나무건너뛰기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] order = new int[N];
			int[] stick = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				order[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(order);
			int j = 0;
			for(int i=0; i<N; i++) {
				if(i%2==0) {
					stick[j/2] = order[N-i-1];
					j++;
				}else {
					stick[N-(j/2)-1] = order[N-i-1];
					j++;
				}
			}
			int diff = 0;
			for(int i=0; i<N-1; i++) {
				int curDiff = Math.abs(stick[i+1]-stick[i]);
				if(curDiff > diff) {
					diff = curDiff;
				}
			}
			int temp = Math.abs(stick[N-1]-stick[0]);
			diff = Math.max(diff, temp);
			sb.append(diff+"\n");
		}
		System.out.print(sb);
	}

}
