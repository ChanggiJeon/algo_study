import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_2138_전구와스위치 {
	static boolean[] input, target, backup;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new boolean[N];
		target = new boolean[N];
		
		String line = br.readLine();
		for(int i=0; i<N; i++) {
			char in = line.charAt(i);
			if(in == '0') input[i] = false;
			else input[i] = true;
		}
		
		line = br.readLine();
		for(int i=0; i<N; i++) {
			char in = line.charAt(i);
			if(in == '0') target[i] = false;
			else target[i] = true;
		}
		
		backup = input.clone();
		input[0] = !input[0];
		input[1] = !input[1];
		
		int ans = Integer.MAX_VALUE;
		int cnt = 1;
		for(int i=0; i<N-1; i++) {
			if(input[i]!=target[i]) {
				switchOn(i+1);
				cnt++;
			}
		}
		if(input[N-1] == target[N-1]) ans = Math.min(cnt, ans);
		
		input = backup.clone();
		
		cnt = 0;
		for(int i=0; i<N-1; i++) {
			if(input[i]!=target[i]) {
				switchOn(i+1);
				cnt++;
			}
		}
		if(input[N-1] == target[N-1]) ans = Math.min(cnt, ans);
		
		
		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}

	private static void switchOn(int i) {
		if(i==0) {
			input[i] = !input[i];
			input[i+1] = !input[i+1];
		}else if(i==N-1) {
			input[i-1] = !input[i-1];
			input[i] = !input[i];
		}else {
			input[i-1] = !input[i-1];
			input[i] = !input[i];
			input[i+1] = !input[i+1];
		}
		
	}

}
