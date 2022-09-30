import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2458_키순서 {
	
	static int N, M;
	static int[] students;
	static int[][] matrix;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		students = new int[N+1];
		matrix = new int[N+1][N+1];
		map = new int[N+1][N+1];
		
		/**1. 입려값을 받는다.
			map[i][j] -> i에서 j로 또는 j에서 i로 순서가 정해지면 1로 체크
			matrix[i][j] -> i에서 j로 갈 수 있는지만 체크
		*/
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			matrix[from][to] = 1;
			map[from][to] = 1;
			map[to][from] = 1;
		}
		
		/**
		 * 
		 * matrix는 경유해서 갈 수 있어도 갈 수 있는 것(순거가 정해지기)이기 때문에 체크
		 * map은 갈 수 있으니까 출발, 도착 모두 체크
		 * 
		 */
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(matrix[i][k] == 1 && matrix[k][j] == 1) {
						matrix[i][j] = 1;
						map[j][i] = 1;
						map[i][j] = 1;
					}
				}
			}
		}
		
		// 출력.
		int ans = 0;
		for(int i=1; i<=N; i++) {
			int cnt = 0;
			for(int j=1; j<=N; j++) {
				if(map[i][j] == 1) {
					cnt++;
				}
			}
			if(cnt == N-1) {
				ans += 1;
			}
		}
		
		System.out.println(ans);
	}
}
