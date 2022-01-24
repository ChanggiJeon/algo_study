import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_16924_십자가찾기 {
	static int R, C, ans;
	static char[][] map;
	static boolean[][] visited;
	static StringBuilder sb;
	static int[][] md = {{1,0},{0,1},{-1,0},{0,-1}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R+1][C+1];
		visited = new boolean[R+1][C+1];
		
		for(int i=1; i<=R; i++) {
			String line = br.readLine();
			for(int j=1; j<=C; j++) {
				map[i][j] = line.charAt(j-1);
				if(map[i][j] == '*') {
					visited[i][j] = true;
				}
			}
		}
		
		findCross();
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				if(visited[i][j]) ans = -1;
			}
		}
		if(ans != -1) {
			System.out.println(ans);
			System.out.print(sb);
		}else {
			System.out.print(ans);
		}
	}

	private static void findCross() {
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				int cnt = countStart(i,j);
				if(map[i][j] == '*' && cnt >0) {
					for(int k=cnt; k>=1; k--) {
						sb.append(i+" "+j+" "+k+"\n");
					}
					ans+= cnt;
				}
			}
		}
		
	}

	private static int countStart(int r, int c) {
		int cnt = 0;
		o: while (true) {
			for (int k = 0; k < 4; k++) {
				int nr = r + cnt * md[k][0];
				int nc = c + cnt * md[k][1];
				if (boundary(nr, nc) || map[nr][nc] != '*') {
					cnt--;
					break o;
				}
			}
			cnt ++;
		}
		if(cnt>0) {
			visited[r][c] = false;
			for (int k = 0; k < 4; k++) {
				int nr = r;
				int nc = c;
				for(int i=0; i<cnt; i++) {
					nr += md[k][0];
					nc += md[k][1];
					visited[nr][nc] = false;
				}
			}
		}
		return cnt;
	}

	private static boolean boundary(int nr, int nc) {
		return nr<1 || nc<1 || nr>R || nc>C;
	}



}
