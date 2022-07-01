import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_7568_덩치 {
	/**
	 * 1. 덩치 큰 사람의 수'만'구하면 됨.(순서 다시 메길 필요 X)
	 * 
	 * 2차원 배열 -> 140ms
	 * 클래스 설계 -> 140ms
	 * 
	 */

	static int N;
	static int[] weight, height;
	static int[][] table;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		weight = new int[N];
		height = new int[N];
		table = new int[N][N];
		StringTokenizer st;
	
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				if(weight[i] < weight[j] && height[i] < height[j]) {
					table[i][j] = 1;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			int ans = 0;
			for(int j=0; j<N; j++) {
				ans += table[i][j];
			}
			ans += 1;
			sb.append(ans+" ");
		}
		
		System.out.println(sb.toString().trim());
	}
}
