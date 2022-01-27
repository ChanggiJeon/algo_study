import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1388_바닥장식 {
	static int R, C, ans;
	static char[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			String line = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		ans = R*C;
		
		count();
		System.out.println(ans);
		
	}

	private static void count() {
		boolean again;
		for(int i=0; i<R; i++) {
			again = false;
			for(int j=0; j<C; j++) {
				if(map[i][j]=='-') {
					if(again) ans -= 1;
					else again = true;
				}else {
					again = false;
				}
			}
		}
		
		for(int i=0; i<C; i++) {
			again = false;
			for(int j=0; j<R; j++) {
				if(map[j][i]=='|') {
					if(again) ans -= 1;
					else again = true;
				}else {
					again = false;
				}
			}
		}
		
	}

}
