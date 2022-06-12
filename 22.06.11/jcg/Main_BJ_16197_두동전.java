import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_16197_두동전 {
	
	/**
	 * 
	 * 1. 같이 떨어지면 안됨
	 * 2. 10번 초과하면 안됨
	 * 3. 방향은 4방향
	 * 
	 * 방문체크 안했을 시 -> 524ms
	 * 방문체크 했을 시 -> 132ms
	 * 
	 */
	static class Coins implements Comparable<Coins>{
		int cnt;
		int[][] coinPositionList;
		
		public Coins(int cnt, int[][] coinPositionList) {
			super();
			this.cnt = cnt;
			this.coinPositionList = coinPositionList;
		}

		@Override
		public int compareTo(Main_BJ_16197_두동전.Coins o) {
			return this.cnt - o.cnt;
		}
	}
	
	static int R, C;
	static int[][] map;
	static boolean[][][][] visited;
	//상, 하, 좌, 우
	static int[] mr = { -1, 1, 0, 0 };
	static int[] mc = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C][R][C];
		
		int[][] coinPositionList = new int[2][2];
		int c = 0;
		
		for(int i=0; i<R; i++) {
			String input = br.readLine();
			for(int j=0; j<C; j++) {
				if(input.charAt(j) == '#') {
					map[i][j] = -1;
				}
				if(input.charAt(j) == 'o') {
					coinPositionList[c][0] = i;
					coinPositionList[c++][1] = j;
				}
			}
		}
		
		int ans = simulate(new Coins(0, coinPositionList));
		System.out.println(ans);
	}

	private static int simulate(Coins coins) {
		PriorityQueue<Coins> que = new PriorityQueue<Main_BJ_16197_두동전.Coins>();
		que.add(coins);
		int vr1 = coins.coinPositionList[0][0];
		int vc1 = coins.coinPositionList[0][1];
		int vr2 = coins.coinPositionList[1][0];
		int vc2 = coins.coinPositionList[1][1];
		
		visited[vr1][vc1][vr2][vc2] = true;
		
		f : while(!que.isEmpty()) {
			Coins o = que.poll();
			if(o.cnt >= 10) {
				continue;
			}
			
			for(int d=0; d<4; d++) {
				int check = 0;
				int[][] newCoinPosition = new int[2][2];
				
				int r1 = o.coinPositionList[0][0];
				int c1 = o.coinPositionList[0][1];
				int r2 = o.coinPositionList[1][0];
				int c2 = o.coinPositionList[1][1];
				
				//1. 이동
				int nr1 = r1 + mr[d];
				int nc1 = c1 + mc[d];
				int nr2 = r2 + mr[d];
				int nc2 = c2 + mc[d];
				
				//2. 떨어졌는지, 막혔는지 체크
				if(outBoundary(nr1, nc1)) {
					check ++;
				}else if(isBlock(nr1,nc1)) {
					newCoinPosition[0][0] = r1;
					newCoinPosition[0][1] = c1;
				}else {
					newCoinPosition[0][0] = nr1;
					newCoinPosition[0][1] = nc1;
				}
				
				if(outBoundary(nr2, nc2)) {
					check ++;
				}else if(isBlock(nr2,nc2)) {
					newCoinPosition[1][0] = r2;
					newCoinPosition[1][1] = c2;
				}else {
					newCoinPosition[1][0] = nr2;
					newCoinPosition[1][1] = nc2;
				}
				
				//3. 1개만 떨어졌으면 return, 방문 안했으면 방문
				if(check == 0 && !visited[nr1][nc1][nr2][nc2]) {
					visited[nr1][nc1][nr2][nc2] = true;
					que.add(new Coins(o.cnt+1, newCoinPosition));
				}else if(check == 1){
					return o.cnt+1;
				}
			}
		}
		
		return -1;
	}

	private static boolean isBlock(int nr, int nc) {
		return map[nr][nc] == -1;
	}

	private static boolean outBoundary(int nr, int nc) {
		return nr<0 || nr>=R || nc<0 || nc>=C;
	}

}
