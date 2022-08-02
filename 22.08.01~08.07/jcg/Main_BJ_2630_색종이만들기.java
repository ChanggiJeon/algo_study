import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2630_색종이만들기 {
	/**
	 * 
	 * Stringbuilder, Stringbuffer -> 가변객체 속도는 builder가 더 빠름
	 * sysout이 얼마 안될때는 sb 쓰는것 보다 그냥 sysout하는게 더 빠름.
	 * 
	 */
	
	static int N, blue, white;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		slice(0,0,N);
		System.out.println(white);
		System.out.print(blue);
	}

	private static void slice(int r, int c, int size) {
		int color = map[r][c];
		
		if(size == 1) {
			if(color == 1) {
				blue++;
			}else {
				white++;
			}
			return;
		}
		
		boolean check = true;
		o: for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(map[i][j]!=color) {
					check = false;
					break o ;
				}
			}
		}
		if(check) {
			if(color == 1) {
				blue++;
			}else {
				white++;
			}
			return;
		}
		
		int half = size/2;
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				slice(r+i*half,c+j*half,half);
			}
		}
	}
}
