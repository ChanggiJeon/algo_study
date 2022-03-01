import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_1261_알고스팟 {
	static class Person implements Comparable<Person>{
		int r, c, wall;

		public Person(int r, int c, int wall) {
			super();
			this.r = r;
			this.c = c;
			this.wall = wall;
		}

		@Override
		public int compareTo(Main_BJ_1261_알고스팟.Person o) {
			return this.wall - o.wall;
		}
		
	}
	
	static int[][] map;
	static int[][] visited;
	static int r,c;
	static int[] mr = {1,0,-1,0};
	static int[] mc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		visited = new int[r][c];
		
		for(int i=0; i<r; i++) {
			Arrays.fill(visited[i], 100000);
			String input = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = input.charAt(j)-'0';
			}
		}
		go();
	}

	private static void go() {
		PriorityQueue<Person> q = new PriorityQueue<Main_BJ_1261_알고스팟.Person>();
		q.add(new Person(0,0,0));
		visited[0][0] = 0;
		
		while(!q.isEmpty()) {
			Person o = q.poll();
			if(o.r == r-1 && o.c == c-1) {
				System.out.println(o.wall);
				break;
			}
			for(int d=0; d<4; d++) {
				int nr = o.r+mr[d];
				int nc = o.c+mc[d];
				if(boundaray(nr,nc)) {
					if(map[nr][nc]==1 && visited[nr][nc]> o.wall+1) {
						q.add(new Person(nr,nc,o.wall+1));
						visited[nr][nc] = o.wall+1;
					}else if(map[nr][nc]==0 && visited[nr][nc] > o.wall) {
						q.add(new Person(nr,nc,o.wall));
						visited[nr][nc] = o.wall;
					}
				}
			}
		}
		
	}

	private static boolean boundaray(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<r && nc<c;
	}

}
