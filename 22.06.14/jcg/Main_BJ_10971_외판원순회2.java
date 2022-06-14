import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_10971_외판원순회2 {
	static int N, min;
	static int[][] table;
	static final int BIG = 777_777_777;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		table = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
				if(table[i][j]==0) {
					table[i][j] = BIG;
				}
			}
		}
		for(int i=1; i<=N; i++) {
			tsp(i,i,1,1<<i,0);
		}
		System.out.println(min);
	}

	private static void tsp(int start, int cur, int cnt, int flag, int cost) {
		if(cnt == N) {
			if(min > cost+table[cur][start]) {
				min = cost + table[cur][start];
			}
		}
		for(int i=1; i<=N; i++) {
			if((flag&1<<i)!=0||table[cur][i]==0) continue;
			tsp(start, i, cnt+1, flag|1<<i, cost+table[cur][i]);
		}
		
	}

}
