import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_3085_사탕게임 {
	static int N;
	static char[][] map;
	static char[] colorList = { 'C', 'P', 'Z', 'Y' };
	static int[] mr = {-1, 1, 0, 0};
	static int[] mc = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		int ans = 0;
		for(int i=0; i<4; i++) {
			ans = Math.max(ans, findMax(colorList[i]));
		}
		System.out.println(ans);
	}

	private static int findMax(char color) {
		int max = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				char cur = map[i][j];
				if(cur == color) {
					max = Math.max(max, checkCross(i, j, color));
				}else {
					for(int d=0; d<4; d++) {
						int nr = i+mr[d];
						int nc = j+mc[d];
						if(boundary(nr, nc) && map[nr][nc]==color) {
							char temp = map[i][j];
							map[i][j] = color;
							map[nr][nc] = temp;
							max = Math.max(max, checkCross(i, j, color));
							map[i][j] = temp;
							map[nr][nc] = color;
						}
					}
				}
			}
		}
		return max;
	}

	private static void print() {
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

	private static boolean boundary(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<N && nc<N;
	}

	private static int checkCross(int r, int c, char color) {
		int cnt = 0;
		int max = 0;
		for(int i=0; i<N; i++) {
			if(map[r][i] == color) {
				cnt ++;
			}else {
				if(max<cnt) {
					max = cnt;
				}
				cnt = 0;
			}
		}
		max = Math.max(max, cnt);
		cnt = 0;
		for(int i=0; i<N; i++) {
			if(map[i][c] == color) {
				cnt ++;
			}else {
				if(max<cnt) {
					max = cnt;
				}
				cnt = 0;
			}
		}
		max = Math.max(max, cnt);
		return max;
	}

}
