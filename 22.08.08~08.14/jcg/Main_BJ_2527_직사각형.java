import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2527_직사각형 {

	/**
	 * 
	 * 16%에서 계속 틀리는데 이유를 모르겠음..
	 * 
	 * 
c
c
c
c

d
d
b
c

d
b
b
c

d
b
b
b

b
b
d

2 2 3 3 3 3 4 4
2 2 3 3 1 1 2 2
2 2 3 3 3 1 4 2
2 2 3 3 1 3 2 4

30 10 50 60 50 80 80 100 
30 60 60 90 60 20 90 50 
30 60 60 90 50 90 80 120 
10 10 20 20 1 1 10 10 

10 10 20 20 1 1 10 8 
10 10 20 20 1 1 10 15 
10 10 20 20 1 1 10 30 
10 10 20 20 1 20 10 30 

10 10 20 20 1 25 10 40 
10 10 20 20 1 15 10 30 
10 10 20 20 1 10 10 20
10 10 20 20 10 15 30 30 <<<<????

10 10 20 20 10 1 30 30 <<<<????
10 10 20 20 10 20 40 40
10 10 20 20 10 30 40 40 

	 */
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
			

			if(x1 == x3 && x2 == x4 && y1 == y3 && y2 == y4) {
				sb.append("b\n");
				continue;
			}else if(isPoint()) {
				continue;
			}else if(isOut()) {
				continue;
			}else if(isLine()) {
				continue;
			}
			sb.append("a\n");
		}
		System.out.print(sb);

	}

	private static boolean isLine() {
		if(x1 == x4 || x1 == x3) {
			sb.append("b\n");
			return true;
		}else if(y2 == y3 || y2 == y4) {
			sb.append("b\n");
			return true;
		}else if(x2 == x4 || x2 == x3) {
			sb.append("b\n");
			return true;
		}else if(y1 == y3 || y1 == y4){
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

	private static boolean isPoint() {
		//사각형 하나랑 다른 사각형이 꼭지점끼리만 만나는 경우의 수 4가지
		if((x1 == x4 && y1 == y4) || (x1 == x4 && y2 == y3) ||
				(x2 == x3 && y2 == y3) || (x2 == x3 && y1 == y4)){
			sb.append("c\n");
			return true;
		}
		return false;
	}
}
