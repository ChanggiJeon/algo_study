import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_14888_연산자끼워넣기 {
	static int N;
	static int[] pick;
	static int[] Numbers;
	static ArrayList<Integer> sign = new ArrayList<Integer>();	
	static int sumMax = Integer.MIN_VALUE;
	static int sumMin = Integer.MAX_VALUE;
	

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		N = Integer.parseInt(br.readLine());
		pick = new int[N];
		Numbers = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			Numbers[i] = Integer.parseInt(st.nextToken());
		}
		StringTokenizer next = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			int a = Integer.parseInt(next.nextToken());
			for(int j =0; j<a; j++) {
				sign.add(i);
			}
		}
		
		Permutation(1,0);
	
		System.out.println(sumMax);
		System.out.println(sumMin);
	}

	private static void Permutation(int cnt, int flag) {
		if(cnt == N) {
			int sum = Numbers[0];
			for(int i=1; i<N; i++) {
				if(pick[i]==0) {
					sum += Numbers[i];
				}else if(pick[i]==1) {
					sum -= Numbers[i];
				} else if (pick[i] == 2) {
					sum *= Numbers[i];
				} else if (pick[i] == 3) {
					sum /= Numbers[i];
				}
			}
			sumMax = Math.max(sumMax, sum);
			sumMin = Math.min(sumMin, sum);
			return;
		}
		for(int i=0; i<N-1; i++) {
			if((flag & 1<<i)!=0) {
				continue;
			}
			pick[cnt] = sign.get(i);
			Permutation(cnt+1, flag | 1<<i);
		}
	}
	
}