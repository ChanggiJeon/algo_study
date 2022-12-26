import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_14502_연구소 {

	static class XY {
		int r, c;
		public XY(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int R, C, max;
	static LinkedList<XY> virusList = new LinkedList<>();
	static int[] mr = {0,1,0,-1};
	static int[] mc = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		max = 0;
		
		int[][] map = new int[R][C];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					virusList.add(new XY(i, j));
				}
			}
		}
		simulation(map,0,0,0);
		System.out.println(max);
	}

	private static void simulation(int[][] arr, int r, int c, int cnt) {
		if(cnt == 3) {
			int[][] spreadMap = spread(arr);
			max = Math.max(count(spreadMap), max);
			return;
		}
		for(int i=r; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					simulation(arr, i, j, cnt+1);
					arr[i][j] = 0;
				}
			}
		}
	}

	private static int count(int[][] arr) {
		int cnt = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j] == 0) {
					cnt ++;
				}
			}
		}
		return cnt;
	}

	private static int[][] spread(int[][] arr) {
		int[][] spreadArr = new int[R][C];
		for(int i=0; i<R; i++) {
			spreadArr[i] = arr[i].clone();
		}
		Queue<XY> que = new LinkedList<>(virusList);
		while(!que.isEmpty()) {
			XY o = que.poll();
			for(int d=0; d<4; d++) {
				int nr = o.r + mr[d];
				int nc = o.c + mc[d];
				if(boundary(nr,nc) && spreadArr[nr][nc]==0) {
					spreadArr[nr][nc] = 2;
					que.add(new XY(nr,nc));
				}
			}
		}
		
		return spreadArr;
	}

	private static boolean boundary(int nr, int nc) {
		return nr>=0 && nr<R && nc>=0 && nc<C;
	}
}
