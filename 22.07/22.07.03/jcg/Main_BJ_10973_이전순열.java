import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_10973_이전순열 {
	/**
	 * 넥퍼 엄청 오랜만이다..
	 * 복습 다시 해야할듯...
	 */
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		if(!np(input)) {
			System.out.println(-1);
		}else {
			System.out.println(sb);
		}
	}
	
	private static boolean np(int [] numbers) {
		int N = numbers.length;
		
		// 꼭지점 찾기.
		int i = N-1;
		while(i>0 && numbers[i-1]<numbers[i]) i--;
		
		if(i==0) return false;
		
		int j = N-1;
		
		while(numbers[i-1]<numbers[j]) j--;
		
		swap(numbers,i-1,j);
		
		int K = N-1;
		while(i<K) {
			swap(numbers, i++, K--);
		}
		
		for(int t=0; t<numbers.length; t++) {
			sb.append(numbers[t]+" ");
		}
		return true;
		}
	
	private static void swap(int[]numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
