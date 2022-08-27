import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_11729_하노이탑이동순서 {
	/**
	 * 
	 * 1. N-1번째를 middle로 옮긴다(재귀)
	 * 2. N번째를 goal로 옮긴다.
	 * 3. N-1번째를 middle에서 goal로 옮긴다(재귀)
	 * 4. 위에 올라와있는 도형이 없으면 그냥 goal로 옮기면 된다.
	 * 
	 */
	static StringBuilder sb = new StringBuilder();
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		hanoi(N,1,2,3);
		System.out.println(cnt);
		System.out.print(sb);
	}

	private static void hanoi(int n, int start, int middle, int goal) {
		if(n==1) {
			sb.append(start+" "+goal+"\n");
			cnt++;
			return;
		}
		hanoi(n-1,start, goal, middle);
		sb.append(start+" "+goal+"\n");
		cnt++;
		hanoi(n-1,middle, start, goal);
	}

}
