import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_BJ_7453_합이0인네정수 {
	/**
	 * 
	 * 아오.. 역대급 최악의 문제
	 * 1. java로 풀면 자료구조 조금만 바꿔도 시간초과 남.
	 * N*logN의 시간복잡도 대신에 N*N을써서 초과나는게 아닌,
	 * N*logN 대신해 N*2*logN하면 시간초과. ;;;
	 * 심지어 java로 푼 어떤사람은 서버 상태에 따라 pass가 달라졌다고 할정도..
	 * 2. 알고리즘 자체는 배우는게 많았음. 4개 어떻게 계산하지 한참을 생각하다가
	 * 결국 찾아보니 2개로 줄인다! 라고 해서 진짜 깜짝 놀랐음.ㄷㄷ
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[4][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[0][i] = Integer.parseInt(st.nextToken());
			arr[1][i] = Integer.parseInt(st.nextToken());
			arr[2][i] = Integer.parseInt(st.nextToken());
			arr[3][i] = Integer.parseInt(st.nextToken());
		}
		
		int[] arr1 = new int[N*N];
		int[] arr2 = new int[N*N];
		
		int k = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr1[k] = arr[0][i]+arr[1][j];
				arr2[k++] = arr[2][i]+arr[3][j];
			}
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		long ans = 0;
		int fidx = 0;
		int sidx = arr2.length-1;
		
		while(fidx<N*N && sidx>=0) {
			int n = arr1[fidx]+arr2[sidx];
			
			if(n>0) {
				sidx--;
			}else if(n<0) {
				fidx++;
			}else {
				int fcnt = 1;
				int scnt = 1;
				while(fidx+1<N*N && (arr1[fidx]==arr1[fidx+1])) {
					fcnt++;
					fidx++;
				}
				while(sidx>0 && (arr2[sidx]==arr2[sidx-1])) {
					scnt++;
					sidx--;
				}
				ans += (long)fcnt*scnt;
				fidx++;
			}
		}
		System.out.println(ans);
	}
}
