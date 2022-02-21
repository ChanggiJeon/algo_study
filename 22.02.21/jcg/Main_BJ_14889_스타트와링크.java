import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14889_스타트와링크 {
	static int N;
	static int map[][];
	static boolean visited[];
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		subSet(0, 0);
		System.out.println(ans);
	}

	static void subSet(int idx, int cur) {
		if(cur==N/2) {
			getTotalPoint();
			return;
		}
		
		for(int i=idx; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				subSet(i+1, cur+1);
				visited[i] = false;
			}
		}
	}

	static void getTotalPoint() {
		int sum_a = 0;
		int sum_b = 0;
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				if(visited[i] && visited[j]) {
					sum_a += map[i][j] + map[j][i];
				}else if(!visited[i] && !visited[j]) {
					sum_b += map[i][j] + map[j][i];
				}
			}
		}
		int diff = Math.abs(sum_a-sum_b);
		if(diff==0) {
			System.out.println(diff);
			System.exit(0);
		}
		ans = Math.min(ans, diff);
	}
}
