import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_10971_외판원순회2 {
	/**
	 * 다익스트라 -> 노드간 최단거리 (출발점에서 각각의 노드까지 가는데 걸리는 최소 비용)
	 * 프림 -> 최소비용신장트리 (가장 적은 비용으로 모든 노드를 연결)
	 * 크루스칼 -> 최소비용신장트리 (union-find 방식으로 구함)
	 * 외판원 순회 문제는 일일이 방문해보면서 최소비용을 구할 수 밖에 없다 -> 브루트포스
	 * dfs로 관리할때 출발지, 현재까지의 비용, 방문체크여부, 방문한 노드수, 현재 노드
	 * 5개를 파라미터로 주는 바람에 상당히 복잡하지만 코드를 매우 빠르게 짤 수 있었음.
	 * 
	 */
	static int n, ans;
	static int[][] matrix;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
		ans = Integer.MAX_VALUE;
		matrix = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<n; i++) {
			dfs(i,0,1,i,1<<i);
		}
		System.out.println(ans);
		
	}

	private static void dfs(int cur, int sum, int cnt, int start, int flag) {
		if(cnt==n) {
			if(matrix[cur][start]!=0) {
				ans = Math.min(sum+matrix[cur][start], ans);
			}
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(matrix[cur][i]==0 || (flag&1<<i)!=0) {
				continue;
			}
			dfs(i, sum+matrix[cur][i], cnt+1, start, flag|1<<i);
		}
		
	}
}
