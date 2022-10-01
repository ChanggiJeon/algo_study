import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11403_경로찾기 {

	static int N;
	static int[][] matrix;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		
		//1. 입력값 받기
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//2. k경로를 통해 i -> k, k -> j로 이동 가능하면 i -> j로 이동가능
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(matrix[i][k] == 1 && matrix[k][j] == 1) {
						matrix[i][j] = 1;
					}
				}
			}
		}
		//3. 출력
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(matrix[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
