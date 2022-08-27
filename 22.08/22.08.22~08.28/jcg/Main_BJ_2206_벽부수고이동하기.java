import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2206_벽부수고이동하기 {
	/**
	 * 
	 * PQ 탐색 -> 1036
	 * Queue Size 탐색 -> 924
	 * 
	 * Queue에서 offer -> 입력 실패시 return false
	 * Queue add -> 입력 실패시 Exception 발생
	 * 
	 * 1000만 데이터 입력시 offer -> 6695ms // add -> 6609
	 * 로컬 실험결과 add가 조~금 더 빠른데, 백준 제출은 더 느림 이유는 모름.
	 */
	static class Hammer{
		int r, c;
		int ableToCrash;

		public Hammer(int r, int c, int ableToCrash) {
			super();
			this.r = r;
			this.c = c;
			this.ableToCrash = ableToCrash;
		}
	}
	static int R,C;
	static int[][] map;
	static boolean[][][] visited;
	static int[] mr = {0,0,-1,1};
	static int[] mc = {1,-1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C][2];
		
		for(int i=0; i<R; i++) {
			String input = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = input.charAt(j)-'0';
			}
		}
		
		int ans = simulation();
		System.out.println(ans);
	}

	private static int simulation() {
		Queue<Hammer> que = new LinkedList();
		que.offer(new Hammer(0,0,1));
		visited[0][0][0] = true;
		int cnt = 1;
		
		while(!que.isEmpty()) {
			int size = que.size();
			
			for(int i=0; i<size; i++) {
				Hammer o = que.poll();
				if(o.r == R-1 && o.c == C-1) {
					return cnt;
				}
				
				for(int d=0; d<4; d++) {
					int nr = o.r + mr[d];
					int nc = o.c + mc[d];
					if(boundary(nr,nc) && !visited[nr][nc][o.ableToCrash]){
						if(map[nr][nc] == 1) {
							if(o.ableToCrash == 1) {
								que.offer(new Hammer(nr,nc,0));
								visited[nr][nc][0] = true;
							}else {
								continue;
							}

						}else {
							que.offer(new Hammer(nr,nc,o.ableToCrash));
							visited[nr][nc][o.ableToCrash] = true;
						}
					}
				}
			}
			cnt += 1;
		}
		
		return -1;
	}

	private static boolean boundary(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<R && nc<C;
	}
}
