import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_BJ_2146_다리만들기 {
	static class XY implements Comparable<XY>{
		int r, c;
		int cnt;

		public XY(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		public XY(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Main_BJ_2146_다리만들기.XY o) {
			return this.cnt - o.cnt;
		}
		
	}

	static int N, min;
	static int[][] map;
	static boolean[][] visited;
	static int landCnt = 2;
	static int mr[] = {0,1,0,-1};
	static int mc[] = {1,0,-1,0};	
	static HashMap<Integer, PriorityQueue<XY>> list = new HashMap<Integer, PriorityQueue<XY>>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		min = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//마킹 안된 섬을 찾으면 번호 바꿔주고 경계라면 hashmap에 넣어주는 메소드 실행.
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] ==1 ) {
					markSameLand(i, j);
				}
			}
		}
		
		//경계에서 다음 섬 찾는 메소드.
		findMin();
		
		System.out.println(min);
		
	}
	 

	private static void findMin() {
		for(int i=2; i<landCnt; i++) {
			PriorityQueue<XY> q = list.get(i);
			visited = new boolean[N][N];
			
			while(!q.isEmpty()) {
				XY o = q.poll();
				if(map[o.r][o.c]!=0 && map[o.r][o.c]!=i) {
					min = Math.min(o.cnt-1,min);
					break;
				}
				for(int d=0; d<4; d++) {
					int nr = o.r + mr[d];
					int nc = o.c + mc[d];
					if(boundary(nr,nc) && !visited[nr][nc] && map[nr][nc]!=i) {
						q.add(new XY(nr,nc,o.cnt+1));
						visited[nr][nc] = true;
					}
				}
			}
		}
	}

	// 같은 섬을 같은 번호로 바꿔주고 경계라면 hashmap에 넣어주는 메소드
	private static void markSameLand(int r, int c) {
		Queue<XY> q = new LinkedList<XY>();
		map[r][c] = landCnt;
		q.add(new XY(r,c));
		PriorityQueue<XY> endPoints = new PriorityQueue<Main_BJ_2146_다리만들기.XY>();
		
		while(!q.isEmpty()) {
			XY o = q.poll();
			for(int d=0; d<4; d++) {
				int nr = o.r + mr[d];
				int nc = o.c + mc[d];
				if (boundary(nr, nc)) {
					if (map[nr][nc] == 1) {
						map[nr][nc] = landCnt;
						q.add(new XY(nr, nc));
					}else if(map[nr][nc] == 0)  {
						if(!visited[o.r][o.c]) {
							visited[o.r][o.c] = true;
							endPoints.add(new XY(o.r,o.c,0));
						}
					}
				}
			}
			
		}
		list.put(landCnt, endPoints);
		landCnt ++;
	}

	private static boolean boundary(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<N && nc<N;
	}
}
