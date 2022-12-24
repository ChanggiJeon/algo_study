package A202209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2583_영역구하기 {
	static int R,C,cnt;
	static boolean[][] map;
	static boolean[][] visited;
	static List<Integer> arr;
	static int[] dy = new int[] {-1,1,0,0};
	static int[] dx = new int[]	{0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new boolean[R][C];
		visited = new boolean[R][C];
		arr = new ArrayList<>();
		while(K-->0) {
			st = new StringTokenizer(br.readLine());
			setRectangle(convertInputCoord(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())})
						, convertInputCoord(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())}));
			
		}
		for(int i = 0 ; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(!map[i][j]&&!visited[i][j]) {
					cnt=0;
					dfs(i,j);
					arr.add(cnt);
				}
			}
		}
		Collections.sort(arr);
		sb.append(arr.size()+"\n");
		for(int a: arr) {
			sb.append(a+" ");
		}
		System.out.println(sb);
	}
	private static void dfs(int row, int col) {
		cnt++;
		visited[row][col]=true;
		for(int d=0; d<4; d++) {
			int nr = row+dy[d];
			int nx = col+dx[d];
			if(nr>=0&&nx>=0&&nr<R&&nx<C&&!visited[nr][nx]&&!map[nr][nx])
				dfs(nr,nx);
		}
	}
	private static int[] convertInputCoord(int[] coord) {
		return new int[] {R-coord[1], coord[0]};
	}
	private static void setRectangle(int[] lc, int[] rc) {
		for(int i = rc[0]; i < lc[0]; i++) {
			for(int j = lc[1]; j < rc[1]; j++) {
				map[i][j]=true;
			}
		}
		
	}
}
