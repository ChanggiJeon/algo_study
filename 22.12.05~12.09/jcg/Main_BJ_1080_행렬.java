import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1080_행렬 {

	static int N, M;
	static int[][] map, goal;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		goal = new int[N][M];
		
		for(int t=0; t<2; t++) {
			for(int i=0; i<N; i++) {
				String input = br.readLine();
				for(int j=0; j<M; j++) {
					if(t==0) {
						map[i][j] = input.charAt(j) - '0';
					}else {
						goal[i][j] = input.charAt(j) - '0';
					}
				}
			}
		}
		boolean flag = true;
		
		if(N<3 || M<3) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] != goal[i][j]) {
						flag = false;
					}
				}
			}
			if(flag) {
				System.out.println(cnt);
			}else {
				System.out.println(-1);
			}
			System.exit(0);
		}
		
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<M-1; j++) {
				if(j!=0 && map[i-1][j-1]!=goal[i-1][j-1]){
					change(i, j);
//					print();
				}
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != goal[i][j]) {
					flag = false;
				}
			}
		}
		
		if(flag) {
			System.out.println(cnt);
		}else {
			System.out.println(-1);
		}
	}

//	private static void print() {
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println("==================");
//	}

	private static void change(int r, int c) {
		for(int i=r-1; i<=r+1; i++) {
			for(int j=c-1; j<=c+1; j++) {
				map[i][j] = 1 - map[i][j];
			}
		}
		cnt++;
	}
}
