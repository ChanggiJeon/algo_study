import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_13459_구슬탈출 {
	static class XY {
		int redR, redC;
		int blueR, blueC;
		
		public XY(int redR, int redC, int blueR, int blueC) {
			super();
			this.redR = redR;
			this.redC = redC;
			this.blueR = blueR;
			this.blueC = blueC;
		}
	}
	
	static int R, C;
	static char[][] map;
	static boolean [][][][] visited;
	static int[] goal = new int[2];
	static int[] start = new int[4];
	static int[] mr = {-1,1,0,0};
	static int[] mc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C][R][C];
		
		for(int i=0; i<R; i++) {
			String line = br.readLine();
			for(int j=0; j<C; j++) {
				char block = line.charAt(j);
				if(block == 'O') {
					goal[0] = i;
					goal[1] = j;
				}else if(block == 'R') {
					start[0] = i;
					start[1] = j;
				}else if(block == 'B') {
					start[2] = i;
					start[3] = j;
				}else {
					map[i][j] = block;
				}
			}
		}
		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<XY> que = new LinkedList<Main_BJ_13459_구슬탈출.XY>();
		que.add(new XY(start[0],start[1],start[2],start[3]));
		visited[start[0]][start[1]][start[2]][start[3]] = true;
		int cnt = 0;
		while(!que.isEmpty()) {
			int size = que.size();
			if(cnt>10) {
				return 0;
			}
			
			for(int i=0; i<size; i++) {
				XY o = que.poll();
				if(o.redR == goal[0] && o.redC == goal[1]) {
					return 1;
				}

				for(int d=0; d<4; d++) {
					int nr = o.redR;
					int nc = o.redC;
					int nbr = o.blueR;
					int nbc = o.blueC;
					while(map[nr+mr[d]][nc+mc[d]] != '#') {
						nr += mr[d];
						nc += mc[d];
						if(nr==goal[0] && nc==goal[1]) {
							break;
						}
					}
					while(map[nbr+mr[d]][nbc+mc[d]] != '#') {
						nbr += mr[d];
						nbc += mc[d];
						if(nbr==goal[0] && nbc==goal[1]) {
							break;
						}
					}
					if(nbr==goal[0] && nbc==goal[1]) {
						continue;
					}

					if(nr == nbr && nc == nbc) {
						switch(d) {
						//상
						case 0:
							if(o.redR>o.blueR) {
								nr += 1;
							}else {
								nbr += 1;
							}
							break;
							//하
						case 1:
							if(o.redR>o.blueR) {
								nbr -= 1;
							}else {
								nr -= 1;
							}
							break;
							//좌
						case 2:
							if(o.redC>o.blueC) {
								nc += 1;
							}else {
								nbc += 1;
							}
							break;
						case 3:
							if(o.redC>o.blueC) {
								nbc -= 1;
							}else {
								nc -= 1;
							}
							break;
						}
					}

					// 방문 체크 && blue가 goal 아니어야함.
					if(!visited[nr][nc][nbr][nbc]) {
						que.add(new XY(nr,nc, nbr,nbc));
						visited[nr][nc][nbr][nbc] = true;
					}
				}
			}
			cnt++;
		}
		return 0;
	}
}

