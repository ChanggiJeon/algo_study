import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BJ_2667_단지번호붙이기 {
	
	static class XY{
		int r, c;

		public XY(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] mr = {0, 0, 1, -1};
	static int[] mc = {1, -1, 0, 0};
	static ArrayList<Integer> count = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					bfs(new XY(i, j));
				}
			}
		}
		
		Collections.sort(count);
		sb.append(count.size()+"\n");
		for(int i=0; i<count.size(); i++) {
			sb.append(count.get(i)+"\n");
		}
		System.out.print(sb);
	}

	private static void bfs(XY s) {
		Queue<XY> que = new LinkedList<Main_BJ_2667_단지번호붙이기.XY>();
		que.add(s);
		visited[s.r][s.c] = true;
		map[s.r][s.c] = 2;
		int cnt = 1;
		while(!que.isEmpty()) {
			XY o = que.poll();
			for(int d=0; d<4; d++) {
				int nr = o.r + mr[d];
				int nc = o.c + mc[d];
				if(boundary(nr,nc) && map[nr][nc] == 1 &&!visited[nr][nc]) {
					que.add(new XY(nr, nc));
					visited[nr][nc] = true;
					map[nr][nc] = 2;
					cnt++;
				}
			}
		}
		count.add(cnt);
	}

	private static boolean boundary(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<N && nc<N;
	}
}
