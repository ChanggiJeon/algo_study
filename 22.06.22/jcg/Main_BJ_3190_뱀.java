import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_3190_뱀 {
	/**
	 * 
	 * 어우.. 그냥 뒷꼬리 계산을 따로 큐로 할껄.
	 * 계산이 이렇게 복잡할 줄은 몰랐는데...
	 *
	 */
	static class Snake{
		int r, c; // 머리 좌표
		int tr, tc; // 꼬리 좌표
		int dir, tdir, length;
		boolean isEat;
		public Snake(int r, int c, int tr, int tc, int dir, int tdir, int length, boolean isEat) {
			super();
			this.r = r;
			this.c = c;
			this.tr = tr;
			this.tc = tc;
			this.dir = dir;
			this.tdir = tdir;
			this.length = length;
			this.isEat = isEat;
		}
	}
	
	static int N, K, L;
	static int[][] map;
	static int[] order = new int[10001];
	//상 우 하 좌 오른쪽은 +1, 왼쪽은 3
	static int[] mr = {-1,0,1,0};
	static int[] mc = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		map[1][1] = 1;
		StringTokenizer st;
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 2;
		}
		L = Integer.parseInt(br.readLine());
		
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char o = st.nextToken().charAt(0);
			if(o == 'D') {
				order[time] = 1;
			}else {
				order[time] = 3;
			}
		}
		
		System.out.println(play());
	}

	private static int play() {
		Queue<Snake> que = new LinkedList<Main_BJ_3190_뱀.Snake>();
		que.add(new Snake(1,1,1,1,1,1,0, false)); //처음 위치 1,1 오른쪽
		int time = 0;
		
		while(!que.isEmpty()){
//			print();
//			System.out.println(time);
//			System.out.println("===========================");
			Snake o = que.poll();

			//1. 방향지시가 있으면 방향 전환
			if(o.isEat) {
				if(order[time]!= 0) {
					o.dir += order[time];
					o.dir %= 4;
				}
			}else {
				if(order[time]!= 0) {
					o.dir += order[time];
					o.dir %= 4;
				}
				if(order[time-o.length]!=0) {
					o.tdir += order[time-o.length];
					o.tdir %= 4;
				}
			}
			
			int nr = o.r + mr[o.dir];
			int nc = o.c + mc[o.dir];
			int ntr = o.tr + mr[o.tdir];
			int ntc = o.tc + mc[o.tdir];
			
			//2. 이동한 머리가 밖으로 나갔거나 자기 몸에 닿으면 아웃!
			if(boundary(nr,nc) || map[nr][nc]==1 ) {
				return time+1;
			}else {
				//3-1. 사과를 먹었다면 머리는 이동하고, 꼬리는 안줄어든다.
				if(map[nr][nc]==2) {
					que.add(new Snake(nr, nc, o.tr, o.tc, o.dir, o.tdir, o.length+1, true));
					map[nr][nc] = 1; 
				//3-2. 사과를 못먹었으면 머리만 이동하고, 꼬리가 줄어든다.
				}else {
					que.add(new Snake(nr, nc, ntr, ntc, o.dir, o.tdir, o.length, false));
					map[nr][nc] = 1;
					map[o.tr][o.tc] = 0; 
				}
			}
			time++;

		}
		return time;
	}

	private static void print() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static boolean boundary(int r, int c) {
		return r<=0 || c<=0 || r>N || c>N;
	}
}
