import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_20056_마법사상어와파이어볼 {
	static class FireBall{
		int r,c,m,dir,speed,turn;

		public FireBall(int r, int c, int m, int speed, int dir, int turn) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.speed = speed;
			this.dir = dir;
			this.turn = turn;
		}
	}
	
	static int N, M, K, T;
	static Queue<FireBall>[][] map;
	static int[] mr = {-1,-1,0,1,1,1,0,-1};
	static int[] mc = {0,1,1,1,0,-1,-1,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new LinkedList[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j] = new LinkedList<FireBall>();
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[r][c].add(new FireBall(r,c,m,s,d,0));
		}
		for(int i=0; i<K; i++) {
			move();
			T++;
			sum();
		}
		
		int ans = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int length = map[i][j].size();
				for(int k=0; k<length; k++) {
					ans += map[i][j].poll().m;
				}
			}
		}
		System.out.println(ans);
	}

	private static void sum() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {				
				int length = map[i][j].size();
				if(length < 2) continue;
				int sumM = 0;
				int sumS = 0;
				boolean flag = true;
				int d = map[i][j].peek().dir%2;
				
				for(int k=0; k<length; k++) {
					FireBall fb = map[i][j].poll();
					sumM += fb.m;
					sumS += fb.speed;
					if(d != fb.dir%2) {
						flag = false;
					}
				}
				
				sumM /= 5;
				sumS /= length;
				if(sumM==0) continue;
				for(int k=0; k<8; k+=2) {
					if(flag) {
						map[i][j].add(new FireBall(i,j,sumM,sumS,k,T));
					}
					else {
						map[i][j].add(new FireBall(i,j,sumM,sumS,k+1,T));
					}
				}
			}
		}
	}
	private static void move() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int length = map[i][j].size();
				for(int k=0; k<length; k++) {
					// 이동 완료된 파이어볼이 나오면 넘어감
					if(map[i][j].peek().turn!=T) break;
					
					FireBall fb = map[i][j].poll();
					int nr = fb.r + mr[fb.dir]*fb.speed;
					int nc = fb.c + mc[fb.dir]*fb.speed;
					while(nr<=0) {
						nr += N;
					}
					while(nr>N) {
						nr -=N;
					}
					while(nc<=0) {
						nc += N;
					}
					while(nc>N) {
						nc -= N;
					}
					map[nr][nc].add(new FireBall(nr,nc,fb.m,fb.speed,fb.dir,fb.turn+1));
				}
			}
		}
	}
	
}
