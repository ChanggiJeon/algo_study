import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_10972_다음순열 {
	static int n;
	static int[] list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		list = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		if(np(list)) {
			for(int i=0; i<n; i++) {
				sb.append(list[i]+" ");
			}
			System.out.println(sb);
		}else {
			System.out.println(-1);
		}
	
	}

	private static boolean np(int[] arr) {
		int i = n-1;
		while(i>0 && list[i-1]>=list[i]) i--;
		if(i==0) return false;
		
		int j = n-1;
		while(list[i-1]>=list[j]) j--;
		
		swap(arr,i-1,j);
		
		int K = n-1;
		while(i<K) {
			swap(arr, i++, K--);
		}
		
		return true;
		}
	
	private static void swap(int[]numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
