import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2527_직사각형 {

	static StringBuilder sb = new StringBuilder();
	static int x1,x2,x3,x4;
	static int y1,y2,y3,y4;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int t=0; t<4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			x3 = Integer.parseInt(st.nextToken());
			y3 = Integer.parseInt(st.nextToken());
			x4 = Integer.parseInt(st.nextToken());
			y4 = Integer.parseInt(st.nextToken());

			if(isPoint()) {
				continue;
			}else if(isOut()) {
				continue;
			}else if(isLine()) {
				continue;
			}else {
				sb.append("a\n");
			}
		}
		System.out.print(sb);

	}

	private static boolean isPoint() {
		//사각형 하나랑 다른 사각형이 꼭지점끼리만 만나는 경우의 수 4가지
		if((x1 == x4 && y1 == y4) || (x1 == x4 && y2 == y3) ||
				(x2 == x3 && y2 == y3) || (x2 == x3 && y1 == y4)){
			sb.append("c\n");
			return true;
		}
		return false;
	}
	
	private static boolean isLine() {
		//x나 y가 같고, 꼭지점에서 만나는게 아니며, 서로 분리되있는 것도 아니면 선분으로 만남.
		if((y1 == y4 && x1 != x4) || (x1 == x4 && y2 != y3) ||
				(y2 == y3 && x2 != x3) || (x2 == x3 && y1 != y4)) {
			sb.append("b\n");
			return true;
		}
		return false;
	}

	private static boolean isOut() {
		//최대값, 최소값 비교.
		if(x2 < x3 || y2 < y3 || x1 > x4 || y1 > y4) {
			sb.append("d\n");
			return true;
		}
		return false;
	}
	
}
