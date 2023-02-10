package A202301;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_20056_마법사상어와파이어볼 {
	static int[] dy = new int[] {-1,-1,0,1,1,1,0,-1};
	static int[] dx = new int[]	{0,1,1,1,0,-1,-1,-1};
	static int[] same = new int[] {0,2,4,6};
	static int[] notSame = new int[] {1,3,5,7};
	static Queue<FireBall> que = new LinkedList<>();
	static List<FireBall>[][] map;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new ArrayList[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<FireBall>();
			}
		}
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			que.add(new FireBall(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		while(K-->0) {
			moveFireBall();
			doingSomething();
		}
		int ans = 0;
		while(!que.isEmpty())ans+=que.poll().m;
		System.out.println(ans);
	}
	private static void doingSomething() {
		List<FireBall> balls;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int sumM=0, sumS=0;
				boolean check = true;
				balls = map[i][j];
				if(balls.size()==0)continue;
				if(balls.size()==1) {
					que.add(balls.get(0));
					map[i][j].clear();
					continue;
				}
				int x = balls.get(0).d%2;
				for(FireBall fb:balls) {
					sumM += fb.m;
					sumS += fb.s;
					if(check && x != fb.d%2)check=false;
				}
				if(sumM < 5) {
					map[i][j].clear();
					continue;
				}
				int[] nextD;
				if(check)nextD=same;
				else nextD=notSame;
				for(int dir = 0; dir < 4; dir++) {
					que.add(new FireBall(i,j,sumM/5,sumS/balls.size(),nextD[dir]));
				}
				map[i][j].clear();
			}
		}
		
	}
	private static void moveFireBall() {
		while(!que.isEmpty()) {
			FireBall fb = que.poll();
			fb.r = fb.r + dy[fb.d] * (fb.s%N);
			fb.c = fb.c + dx[fb.d] * (fb.s%N);
			if(fb.r >= N)fb.r-=N;
			if(fb.r < 0)fb.r+=N;
			if(fb.c >= N)fb.c-=N;
			if(fb.c < 0)fb.c+=N;
			map[fb.r][fb.c].add(fb);
		}
	}
	static class FireBall{
		int r,c,m,s,d;
		public FireBall(int r, int c, int m, int s, int d) {
			this.r=r;this.c=c;this.m=m;this.s=s;this.d=d;
		}
	}
}
