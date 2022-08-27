import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_18353_병사배치하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] LIS = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 1;
		for(int i=0; i<N; i++) {
			LIS[i] = 1;
			
			for(int j=0; j<i; j++) {
				if(arr[j]>arr[i] && LIS[i]<LIS[j]+1) {
					LIS[i] = LIS[j]+1;
				}
				if(max<LIS[i]) {
					max = LIS[i];
				}
			}
		}
		System.out.println(N-max);
	}

}
