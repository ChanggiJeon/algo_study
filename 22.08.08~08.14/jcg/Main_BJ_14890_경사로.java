import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14890_경사로 {
	
	static int N, L, ans;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		isPass();
		System.out.println(ans);
	}

	private static void isPass() {
		o : for(int i=0; i<N; i++) {
			int curFloor = map[i][0];
			int flat = 1;
			boolean isDept = false;
			
			for(int j=1; j<N; j++) {
				//1. 같다면 flat 스택 1 더함
				if(map[i][j] == curFloor) {
					flat ++;
				// 차이가 2이상이면
				}else if(Math.abs(map[i][j] - curFloor) >= 2) {
					continue o;
				// 차이가 1이하이고, 높아진다면
				}else if(map[i][j] > curFloor){
					//1. 빚이 있을 때는 2L 만큼 필요
					if(isDept) {
						if(flat>=L*2) {
							flat = 1;
							curFloor = map[i][j];
							isDept = false;
						}else {
							continue o;
						}
					//2. 빚이 없을 때는 경사로 L만큼 필요
					}else {
						if(flat>=L) {
							flat = 1;
							curFloor = map[i][j];
						}else {
							continue o;
						}
					}
				// 차이가 1이하고, 낮아진다면
				}else if(map[i][j] < curFloor){
					//1. 경사로 필수 건설이면 만들 수 있는지 체크
					if(isDept && flat<L) {
						continue o;
					}else {
						flat = 1;
						curFloor = map[i][j];
						isDept = true;
					}
				}
			}
			if(!isDept || (isDept && flat >=L)) {
				ans ++;
			}
		}
		
		o : for(int j=0; j<N; j++) {
			int curFloor = map[0][j];
			int flat = 1;
			boolean isDept = false;
			
			for(int i=1; i<N; i++) {
				//1. 같다면 flat 스택 1 더함
				if(map[i][j] == curFloor) {
					flat ++;
				// 차이가 2이상이면
				}else if(Math.abs(map[i][j] - curFloor) >= 2) {
					continue o;
				// 차이가 1이하이고, 높아진다면
				}else if(map[i][j] > curFloor){
					//1. 빚이 있을 때는 2L 만큼 필요
					if(isDept) {
						if(flat>=L*2) {
							flat = 1;
							curFloor = map[i][j];
							isDept = false;
						}else {
							continue o;
						}
					//2. 빚이 없을 때는 경사로 L만큼 필요
					}else {
						if(flat>=L) {
							flat = 1;
							curFloor = map[i][j];
						}else {
							continue o;
						}
					}
				// 차이가 1이하고, 낮아진다면
				}else if(map[i][j] < curFloor){
					//1. 경사로 필수 건설이면 만들 수 있는지 체크
					if(isDept && flat<L) {
						continue o;
					}else {
						flat = 1;
						curFloor = map[i][j];
						isDept = true;
					}
				}
			}
			if(!isDept || (isDept && flat >=L)) {
				ans ++;
			}
		}
	}
}
