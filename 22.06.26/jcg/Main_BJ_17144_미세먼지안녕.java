import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17144_미세먼지안녕 {
	static class Dust{
		int r;
		int c;
		int amount;
		public Dust(int r, int c, int amount) {
			super();
			this.r = r;
			this.c = c;
			this.amount = amount;
		}
		
	}

	static int R,C,T;
	static int[][] map;
	static int[] airCon;
	static int[] mr = {0,1,0,-1}; //우 하 좌 상
	static int[] mc = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
	    airCon = new int[2];
		int a = 0;
		map = new int[R+1][C+1];

		
		for(int i=1; i<=R; i++) {
			StringTokenizer t = new StringTokenizer(br.readLine());
			for(int j=1; j<=C; j++) {
				int in = Integer.parseInt(t.nextToken());
				map[i][j] = in;
				if(in == -1) {
					airCon[a++] = i;
				}
			}
		}
		for(int t=0; t<T; t++) {
			spread();
//			for(int i =1; i<=R; i++) {
//				for(int j=1; j<=C; j++) {
//					System.out.print(map[i][j]+" ");
//				}System.out.println();
//			}
			airCirculation();
//			System.out.println("=============");
//			for(int i =1; i<=R; i++) {
//				for(int j=1; j<=C; j++) {
//					System.out.print(map[i][j]+" ");
//				}System.out.println();
//			}
//			System.out.println("==============");
		}
		int result = 0;
		for(int i =1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				int f = map[i][j];
				if(f!=-1) result += f;
			}
		}
		System.out.println(result);
		
	}

	private static void spread() {
		int[][] Nmap = new int[R+1][C+1];

		for(int i =1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				int cnt = 0;
				int amount = map[i][j];
				if(amount<5) {
					Nmap[i][j] += amount;
					continue;
				}
				for(int d=0; d<4; d++) {
					int nr = i+mr[d];
					int nc = j+mc[d];
					if(nr>=1 && nr<=R && nc>=1 && nc<=C && map[nr][nc]!=-1) {
						cnt++;
						Nmap[nr][nc] += amount/5;
					}
				}
				Nmap[i][j] += amount - ((amount/5)*cnt);
			}
		}

		for(int i=1; i<=R; i++) {
			map[i] = Nmap[i].clone();
		}
		map[airCon[0]][1] = -1;
		map[airCon[1]][1] = -1;
	}

	private static void airCirculation() {
		int up = airCon[0];
		int down = airCon[1];
		// 윗순환
		for(int i=up-1; i>1; i--) {
			map[i][1] = map[i-1][1];
		}
		for(int j=1; j<C; j++) {
			map[1][j] = map[1][j+1];
		}
		for(int i=1; i<up; i++) {
			map[i][C] = map[i+1][C];
		}
		for(int j=C; j>1; j--) {
			map[up][j] = map[up][j-1];
		}
		map[up][2] = 0;
		
		
		//아래순환
		for(int i=down+1; i<R; i++) {
			map[i][1] = map[i+1][1];
		}
		for(int j=1; j<C; j++) {
			map[R][j] = map[R][j+1];
		}
		for(int i=R; i>down; i--) {
			map[i][C] = map[i-1][C];
		}
		for(int j=C; j>1; j--) {
			map[down][j] = map[down][j-1];
		}
		map[down][2] = 0;
		
	}

}
