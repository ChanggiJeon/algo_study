package Simulation자료구조;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_14503_로봇청소기 {
	static class Robot{
		int r, c, d;

		public Robot(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	
	static int R,C;
	static int[][] map;
	// 북, 서, 남, 동
	static int[] mr = {-1, 0, 1, 0};
	static int[] mc = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		if(d == 1) {
			d = 3;
		}else if(d == 3) {
			d = 1;
		}
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = doCleaning(new Robot(r,c,d));
		System.out.println(ans);
	}

	private static int doCleaning(Robot robot) {
		Queue<Robot> que = new LinkedList<Main_BJ_14503_로봇청소기.Robot>();
		que.add(robot);
		int clean = 1;
		map[robot.r][robot.c] = -1;
		
		while(!que.isEmpty()) {
			Robot o = que.poll();
//			print();
			
			boolean check = true;
			for(int i=1; i<=4; i++) {
				int nd = (o.d+i)%4;
				int nr = o.r + mr[nd];
				int nc = o.c + mc[nd];
				//1. 왼쪽이 청소 아직 안한 빈공간이면 회전 후 전진
				if(map[nr][nc] == 0) {
					que.add(new Robot(nr, nc, nd));
					check = false;
					break;
				}
			}
			if(check) {
				int nr = o.r + mr[(o.d+2)%4];
				int nc = o.c + mc[(o.d+2)%4];
				if(map[nr][nc] == 1) {
					return clean;
				}else {
					que.add(new Robot(nr, nc, o.d));
				}
			}
		}
		return 0;
	}

	private static void print() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
