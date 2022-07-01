import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_2108_통계학 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] idx = new int[10000];
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			idx[arr[i]+4000]++;
		}
		double A = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			A += arr[i];
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		int cnt = 0;
		int id = 0;
		for(int i=min; i<=max; i++) {
			if(cnt<idx[i+4000]) {
				cnt = idx[i+4000];
			}
		}
		int k = 0;
		for(int i=min; i<=max; i++) {
			if(idx[i+4000] == cnt && k<2) {
				id = i;
				k++;
			}
		}
		Arrays.sort(arr);
		System.out.println(Math.round(A/(double)N));
		System.out.println(arr[N/2]);
		System.out.println(id);
		System.out.println(max - min);
	}

}
