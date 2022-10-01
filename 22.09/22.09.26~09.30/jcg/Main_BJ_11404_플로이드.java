import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_11404_플로이드 {
	static final int INF = 100_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] matrix = new int[N+1][N+1];
		
		//0. 거리값을 우선 최대로 맞춰놓는다.(최소 거리 구할 예정이기 때문)
		for(int i=1; i<=N; i++) {
			Arrays.fill(matrix[i], INF);
		}
		
		//1. 입력값 받기 노선이 두개일 수 있는데, 그럴경우 비용을 최소값으로 갱신해주면된다.
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			//1-1 비용 갱신 내용.
			if(matrix[from][to]>cost) {
				matrix[from][to] = cost;
			}
		}
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				//어차피 경로와 출발지가 같으면 값 변화 x
				if(i==k) continue;
				for(int j=1; j<=N; j++) {
					//자기 자신에서 출발해서 자기자신에 도착하면 암됨.
					if(i==j) continue;
					matrix[i][j] = Math.min(matrix[i][j], matrix[i][k]+matrix[k][j]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				//거리가 갱신되지 않았다면 갈 수 없음.
				if(matrix[i][j] == INF) {
					sb.append(0+" ");
				}else {
					sb.append(matrix[i][j]+" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
