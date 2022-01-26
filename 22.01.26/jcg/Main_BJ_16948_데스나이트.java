import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16948_데스나이트 {
	static class knight{
		int r,c,cnt;

		public knight(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	static int[] mr = {-2,-2,0,0,2,2};
	static int[] mc = {-1,1,-2,+2,-1,1};
	static int N;
	static boolean [][] visited;
	static int[] goal = new int[2];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		knight init = new knight(x,y,0);
		goal[0] = Integer.parseInt(st.nextToken());
		goal[1] = Integer.parseInt(st.nextToken());
		
		visited[x][y] = true;
		int ans = countCnt(init);
		
		System.out.println(ans);
	}

	private static int countCnt(Main_BJ_16948_데스나이트.knight init) {
		Queue<knight> q = new LinkedList<Main_BJ_16948_데스나이트.knight>();
		q.add(init);
		while(!q.isEmpty()) {
		
			knight out = q.poll();
			if(out.r == goal[0] && out.c == goal[1]) {
				return out.cnt;
			}
			for(int i=0; i<6; i++) {
				int nr = out.r+mr[i];
				int nc = out.c+mc[i];
				if(boundary(nr,nc) && !visited[nr][nc]) {
					q.add(new knight(nr,nc,out.cnt+1));
					visited[nr][nc] = true;
				}
			}
		}
		
		return -1;
		
	}

	private static boolean boundary(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<N && nc<N;
	}

}
