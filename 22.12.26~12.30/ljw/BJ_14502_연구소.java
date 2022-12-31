package om9d17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_14502_연구소 {
	static int R,C, max = 0;
	static int[][] field;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		field = new int[R][C];
		int[] zero = new int[R*C];
		
		for(int i = 0 ; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < C; j++) {
				int a = Integer.parseInt(st.nextToken());
				field[i][j] = a;
				if(a == 0) {
					zero[C*i + j] = 1;
				}
			}
		}
		comb(zero, 0, 0, new int[3]);
		System.out.println(max);
	}
	public static void comb(int[] zero, int r, int n, int[] zeroindex) {
		if(r >= 3) {
			int[][] result = new int[R][C];
	         
	        for(int i=0; i<R; i++){
	            System.arraycopy(field[i], 0, result[i], 0, C);
	        }
			for(int i = 0 ; i < 3; i++) {
				int a = zeroindex[i] / C;
				int b = zeroindex[i] % C;
				result[a][b] = 1;
			}
			int temp = bfs(result);
//			System.out.println(temp);
			max = Math.max(temp, max);
			return;
		}
		if(n >= R*C) {
			return;
		}
		if(zero[n] != 1) {
			comb(zero, r, n+1, zeroindex);
			
		}else {
			zeroindex[r] = n;
			comb(zero, r+1, n+1, zeroindex);
			comb(zero, r, n+1, zeroindex);
		}
	}
	static int[] dx = new int[] {0,0,-1,1};
	static int[] dy = new int[] {-1,1,0,0};
	public static int bfs(int[][] result) {
		Queue<int[]> que = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];
		for(int i =0 ; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(result[i][j] == 2) {
					visited[i][j] = true;
					que.offer(new int[] {i, j});
				}
			}
		}
		while(!que.isEmpty()) {
			int[] tmp = que.poll();
			for(int d =0; d < 4; d++) {
				int xx = tmp[1] + dx[d];
				int yy = tmp[0] + dy[d];
				if(xx < 0 || yy < 0 || xx >= C || yy >= R || visited[yy][xx])continue;
				visited[yy][xx] = true;
				if(result[yy][xx] == 0) {
					result[yy][xx] = 2;
					que.offer(new int[] {yy, xx});
				}
			}
		}
		int cnt = 0;
		for(int i =0 ; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(result[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
