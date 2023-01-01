import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_14938_서강그라운드 {

	static int N, M, R;
	static int[] itemCnt;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		itemCnt = new int[N+1];
		
		int[][] map = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			Arrays.fill(map[i], 1000);
			map[i][i] = 0;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			itemCnt[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			map[from][to] = map[to][from] = length;
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					map[i][j] = Math.min(map[i][k]+map[k][j], map[i][j]);
				}
			}
		}
		
		int ans = 0;
		for(int i=1; i<=N; i++) {
			int cnt = 0;
			for(int j=1; j<=N; j++) {
				if(map[i][j]<=M) {
					cnt += itemCnt[j];
				}
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
}
