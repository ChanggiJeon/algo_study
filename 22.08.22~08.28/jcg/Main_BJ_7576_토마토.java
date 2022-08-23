import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_7576_토마토 {
	static class Cordinate{
		int r, c;
		
		public Cordinate(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int[][] map;
	static int R, C, cnt;
	static int[] mr = {0,0,1,-1};
	static int[] mc = {1,-1,0,0};
	static Queue<Cordinate> que = new LinkedList<Main_BJ_7576_토마토.Cordinate>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] ==1) {
					que.add(new Cordinate(i,j));
				}else if(map[i][j] == 0) {
					cnt++;
				}
			}
		}
		
		int days = tomato();
		System.out.println(days);
	}

	private static int tomato() {
		
		if(cnt == 0) {
			return 0;
		}
		
		int days = 0;
		
		while(!que.isEmpty()) {
			int size = que.size();
			for(int i=0; i<size; i++) {
				Cordinate o = que.poll();
				for(int d=0; d<4; d++) {
					int nr = o.r + mr[d];
					int nc = o.c + mc[d];
					if(boundary(nr,nc) && map[nr][nc]==0) {
						que.add(new Cordinate(nr,nc));
						map[nr][nc] = 1;
						cnt--;
					}
				}
			}
			days++;
		}
		if(cnt == 0) {
			return days-1;
		}
		return -1;
	}

//	private static void print() {
//		for(int i=0; i<R; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println("===========================");
//		
//	}

	private static boolean boundary(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<R && nc<C;
	}

}
