import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ__2583_영역구하기 {
	static class XY {
		int r, c;
		public XY(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int R, C, K;
	static boolean[][] map;
	static int[] mr = {0,0,1,-1};
	static int[] mc = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new boolean[R+1][C+1];
		
		for(int i=0; i<K; i++) {
			String[] input = br.readLine().split(" ");
			int c1 = Integer.parseInt(input[0]);
			int r2 = R - Integer.parseInt(input[1]);
			int c2 = Integer.parseInt(input[2]);
			int r1 = R - Integer.parseInt(input[3]);
			for(int r=r1; r<r2; r++) {
				for(int c=c1; c<c2; c++) {
					map[r][c] = true;
				}
			}
		}
		for(int i=0; i<=R; i++) {
			map[i][C] = true;
		}
		for(int i=0; i<=C; i++) {
			map[R][i] = true;
		}
		
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0; i<=R; i++) {
			for(int j=0; j<=C; j++) {
				if(!map[i][j]) {
					arr.add(bfs(i,j));
				}
			}
		}
		
		Collections.sort(arr);
		sb.append(arr.size()+"\n");
		for(int i=0; i<arr.size(); i++) {
			sb.append(arr.get(i)+" ");
		}
		System.out.println(sb);
	}

	private static int bfs(int r, int c) {
		Queue<XY> que = new LinkedList<>();
		que.add(new XY(r,c));
		map[r][c] = true;
		int cnt = 1;
		
		while(!que.isEmpty()) {
			XY o = que.poll();
			for(int d=0; d<4; d++) {
				int nr = o.r + mr[d];
				int nc = o.c + mc[d];
				if(boundary(nr,nc) && !map[nr][nc]) {
					map[nr][nc] = true;
					que.add(new XY(nr, nc));
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static boolean boundary(int nr, int nc) {
		return nr>=0 && nr<=R && nc>=0 && nc<=C;
	}
}
