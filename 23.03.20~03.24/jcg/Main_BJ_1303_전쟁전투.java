import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1303_전쟁전투 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		boolean[][] visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			String input = br.readLine();
			for(int j=0; j<C; j++){
				map[i][j] = input.charAt(j);
			}
		}
		int W = 0;
		int B = 0;
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(!visited[i][j]) {
					if(map[i][j] == 'W') {
						W += bfs(i,j,map,'W',visited,R,C);
					}else {
						B += bfs(i,j,map,'B',visited,R,C);
					}
				}
			}
		}
		System.out.print(W+" "+B);
	}

	private static int bfs(int r, int c, char[][] map, char color, 
			boolean[][] visited, int R, int C) {
		int[] mr = {0,1,0,-1};
		int[] mc = {1,0,-1,0};
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {r,c});
		visited[r][c] = true;
		int power = 1;
		
		while(!que.isEmpty()) {
			int[] out = que.poll();
			for(int d=0; d<4; d++) {
				int nr = out[0] + mr[d];
				int nc = out[1] + mc[d];
				if(boundary(nr,nc,R,C) && map[nr][nc] == color && !visited[nr][nc]) {
					que.add(new int[] {nr,nc});
					visited[nr][nc] = true;
					power += 1;
				}
			}
		}
		
		return power*power;
	}

	private static boolean boundary(int nr, int nc, int R, int C) {
		return nr>=0 && nc>=0 && nr<R && nc<C;
	}

}
