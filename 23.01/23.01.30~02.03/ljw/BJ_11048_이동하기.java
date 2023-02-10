package A202302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11048_이동하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int [][] miro = new int[R][C];
		for(int i = 0 ; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < C; j++) {
				miro[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 1; i < R; i++) {
			miro[i][0] = miro[i][0] + miro[i-1][0];
		}
		for(int i = 1; i < C; i++) {
			miro[0][i] = miro[0][i] + miro[0][i-1];
		}
		for(int i = 1 ; i < R; i++) {
			for(int j = 1; j < C; j++) {
				miro[i][j] = miro[i][j] + Math.max(miro[i-1][j], miro[i][j-1]);
			}
		}
		System.out.println(miro[R-1][C-1]);
	}

}
