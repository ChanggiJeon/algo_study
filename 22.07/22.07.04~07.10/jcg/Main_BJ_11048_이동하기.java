import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11048_이동하기 {
	/**
	 * 
	 * 조건에서 DP[i][j] < map[i][j] + DP[i-1][j] 넣을 경우 -> 528ms
	 * Math.max로 계산할 경우 -> 572ms
	 * 
	 */

	static int R, C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R+1][C+1];
		for(int i=1; i<=R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] DP = new int[R+1][C+1];
		DP[1][1] = map[1][1];
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				if(boundary(i-1,j) && DP[i][j] < map[i][j] + DP[i-1][j]) {
					DP[i][j] = map[i][j] + DP[i-1][j];
				}
				if(boundary(i,j-1) && DP[i][j] < map[i][j] + DP[i][j-1]) {
					DP[i][j] =  map[i][j] + DP[i][j-1];
				}
				if(boundary(i-1,j-1) && DP[i][j] < map[i][j] + DP[i-1][j-1]) {
					DP[i][j] = map[i][j] + DP[i-1][j-1];
				}
			}
		}
		System.out.println(DP[R][C]);

	}

	private static boolean boundary(int r, int c) {
		return r>=1 && c>=1 && r<=R && c<=C;
	}

}
