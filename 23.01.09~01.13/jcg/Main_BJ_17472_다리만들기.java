import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17472_다리만들기 {

	static int N, M, cnt;
	static int[][] map, matrix;
	static boolean[][] visited;
	static int[] mr = {0,0,1,-1};
	static int[] mc = {1,-1,0,0};
	static final int MAX = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = 1;
		map = new int[N][M];
		visited = new boolean[N][M];
		
		//1. 입력받기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int input = Integer.parseInt(st.nextToken());
				if(input == 1) {
					map[i][j] = -1;
				}else {
					map[i][j] = 0;
				}
			}
		}
		
		//2. 섬 나누기
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j] && map[i][j] == -1) {
					marking(i,j);
					cnt++;
				}else {
					visited[i][j] = true;
				}
			}
		}

		// 인덱스 1부터 사용했으니 그냥 cnt만큼.
		matrix = new int[cnt][cnt];
		for(int i=0; i<cnt; i++) {
			Arrays.fill(matrix[i], MAX);
		}
		
		//3. 섬에서 섬까지 최소값 구하기
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] > 0) {
					move(i,j,map[i][j]);
				}
			}
		}
		
		//4. 최소신장 비용트리 만들기
		int[] distance = new int[cnt];
		boolean[] visited = new boolean[cnt];
		Arrays.fill(distance, MAX);
		int ans = 0;
		distance[1] = 0;
		
		for(int i=1; i<cnt; i++) {
			int min = MAX;
			int current = -1;
			for(int j=1; j<cnt; j++) {
				if(!visited[j] && distance[j]<min) {
					min = distance[j];
					current = j;
				}
			}
			if(current == -1) {
				System.out.println(-1);
				System.exit(0);
			}
			ans += min;
			visited[current] = true;
			for(int j=1; j<cnt; j++) {
				if(!visited[j] && distance[j]>matrix[current][j]) {
					distance[j] = matrix[current][j];
				}
			}
		}
		System.out.println(ans);
	}

	private static void move(int sr, int sc, int landNum) {
		for(int d=0; d<4; d++) {
			int moveCnt = 0;
			int r = sr;
			int c = sc;
			while(true) {
				int nr = r + mr[d];
				int nc = c + mc[d];
				if(!boundary(nr,nc) || map[nr][nc]==landNum) {
					break;
				}else if(map[nr][nc]==0) {
					moveCnt++;
					r = nr;
					c = nc;
				}else if(moveCnt >= 2){
					matrix[landNum][map[nr][nc]] = Math.min(matrix[landNum][map[nr][nc]], moveCnt);
					break;
				}else {
					break;
				}
			}
		}
	}

	private static void marking(int r, int c) {
		Queue<int[]> que = new LinkedList<>();
		map[r][c] = cnt;
		visited[r][c] = true;
		que.add(new int[] {r,c});
		
		while(!que.isEmpty()) {
			int[] out = que.poll();
			for(int d=0; d<4; d++) {
				int nr = out[0] + mr[d];
				int nc = out[1] + mc[d];
				if(boundary(nr,nc) && !visited[nr][nc] && map[nr][nc] == -1) {
					map[nr][nc] = cnt;
					que.add(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
			}
		}
	}

	private static boolean boundary(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<M;
	}
}
