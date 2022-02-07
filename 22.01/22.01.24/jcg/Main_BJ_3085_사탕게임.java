import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_3085_사탕게임 {
	static char[][] map;
	static int N, max;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		change();
		System.out.println(max);
		
	}

	private static void change() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-1; j++) {
				if(map[i][j]!= map[i][j+1]) {
					char temp = map[i][j];
					map[i][j] = map[i][j+1];
					map[i][j+1] = temp;
					check();
					map[i][j+1] = map[i][j];
					map[i][j] = temp;
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-1; j++) {
				if(map[j][i]!= map[j+1][i]) {
					char temp = map[j][i];
					map[j][i] = map[j+1][i];
					map[j+1][i] = temp;
					check();
					map[j+1][i] = map[j][i];
					map[j][i] = temp;
				}
			}
		}
		
	}

	private static void check() {
		
		//가로 비교
		for(int i=0; i<N; i++) {
			char start = map[i][0];
			int cnt = 0;
			for(int j=0; j<N; j++) { 
				if(start==map[i][j]) { //색이 같으면 cnt ++;
					cnt++;
				}else { // 색이 다르면 다른 색으로 바꾸고 max값 넣고 cnt 초기화
					max = Math.max(max, cnt);
					cnt = 1;
					start = map[i][j];
				}
			}
			max = Math.max(max, cnt);
		}
		//세로 비교
		for(int i=0; i<N; i++) {
			char start = map[0][i];
			int cnt = 0;
			for(int j=0; j<N; j++) { 
				if(start==map[j][i]) { //색이 같으면 cnt ++;
					cnt++;
				}else { // 색이 다르면 다른 색으로 바꾸고 max값 넣고 cnt 초기화
					max = Math.max(max, cnt);
					cnt = 1;
					start = map[j][i];
				}
			}
			max = Math.max(max, cnt);
		}
	}
}
