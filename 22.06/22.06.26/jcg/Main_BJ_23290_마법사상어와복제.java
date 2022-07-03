import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_23290_마법사상어와복제 {
	/**
	 * 
	 * 어우.. 얕은 복사때문에 1시간 날렸음.
	 * 시뮬레이션 끝판왕 문제.
	 * 구지 class정의 안하고 방향처럼 경우수가 정해져있으면 배열로 푸는게 좋다.
	 * 
	 */
	
	static int M, S, fishMax;
	static int[][] pick = new int[3][2];
	static int[][] sharkMove = new int[3][2];
	//살아있는 생선
	static int[][][] map = new int[5][5][9];
	//생선 냄새
	static int visited[][] = new int[5][5];
	//생선 이동 방향
	static int[] mr = {0,0,-1,-1,-1,0,1,1,1};
	static int[] mc = {0,-1,-1,0,1,1,1,0,-1};
	//상 좌 하 우
	static int[] sr = {-1, 0, 1, 0};
	static int[] sc = {0, -1, 0, 1};
	static int sharkR, sharkC;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[r][c][d]++;
		}
		st = new StringTokenizer(br.readLine());
		sharkR = Integer.parseInt(st.nextToken());
		sharkC = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<S; i++) {
			simulation();
		}
		int ans = 0;
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=4; j++) {
				for(int d=1; d<=8; d++) {
					ans += map[i][j][d];
				}
			}
		}
		System.out.println(ans);
	}

	private static void simulation() {
		//1. 복사
		int[][][] copy = new int[5][5][9];
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=4; j++) {
				copy[i][j] = map[i][j].clone();
			}
		}
		//2. 물고기 이동
		int[][][] move = new int[5][5][9];
		
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=4; j++) {;
				o: for(int d=1; d<=8; d++) {
					int o = map[i][j][d];
					int nr = i + mr[d];
					int nc = j + mc[d];
					int dir = d;
					int cnt = 1;
					while(outBound(nr,nc) || visited[nr][nc]!=0 || (nr==sharkR && nc==sharkC)) {
						if(cnt>8) {
							//이동할 곳 없으면 이동안하고 다음 물고기로.
							move[i][j][d] += map[i][j][d]; 
							continue o;
						}
						dir = (dir -1);
						if(dir == 0) {
							dir = 8;
						}
						nr = i + mr[dir];
						nc = j + mc[dir];
						cnt ++;
					}
					move[nr][nc][dir] += map[i][j][d]; 
				}
			}
		}
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=4; j++) {
				map[i][j] = move[i][j].clone();
			}
		}
		
		//3. 상어 이동
		fishMax = -1;
		moveShark(sharkR, sharkC, 0, 0);
		for(int i=0; i<3; i++) {
			sharkR = sharkMove[i][0];
			sharkC = sharkMove[i][1];
			int check = 0;
			for(int d=1; d<=8; d++) {
				check += map[sharkR][sharkC][d];
				map[sharkR][sharkC][d] = 0;
			}
			if(check>0) {
				visited[sharkR][sharkC] = 3;
			}
		}
		
		//4. 물고기 냄새 갱신
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=4; j++) {
				if(visited[i][j]!=0) {
					visited[i][j]--;
				}
			}
		}
		//5.복제된 copy의 물고기 map에 투하.
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=4; j++) {
				for(int k=1; k<=8; k++) {
					map[i][j][k] += copy[i][j][k];
				}
			}
		}
	}

	private static boolean outBound(int nr, int nc) {
		return nr<1 || nc<1 || nr>4 || nc>4;
	}

	private static void moveShark(int r, int c, int cnt, int sum) {
		if(cnt==3) {
			if(sum>fishMax) {
				fishMax = sum;
				for(int i=0; i<3; i++) {
					sharkMove[i] = pick[i].clone();
				}
			}
			return;
		}
		for(int d=0; d<4; d++) {
			int nr = r+sr[d];
			int nc = c+sc[d];
			if(outBound(nr,nc)) {
				continue;
			}else {
				pick[cnt][0] = nr;
				pick[cnt][1] = nc;
				boolean isVisited = false;
				for(int i=0; i<cnt; i++) {
					if(pick[i][0] == nr && pick[i][1] == nc) {
						isVisited = true;
						break;
					}
				}
				if(isVisited) {
					moveShark(nr, nc, cnt+1, sum);
				}else {
					int count = 0;
					for(int j=1; j<=8; j++) {
						count += map[nr][nc][j];
					}
					moveShark(nr, nc, cnt+1, sum+count);
				}
			}
		}
		
	}

}
