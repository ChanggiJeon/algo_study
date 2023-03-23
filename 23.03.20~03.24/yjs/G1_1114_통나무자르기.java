package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class G1_1114_통나무자르기 {
	static int L;
	static int K;
	static int C;
	static int spots[];
	static boolean visited[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		spots = new int[K];
		visited = new boolean[K];
		// 자르기 최적의 위치 단위
		double unit = L / C;
		
		st = new StringTokenizer(br.readLine());
		// set으로 중복 제거 및 spots 정렬
		Set<Integer> set = new HashSet<>();
		for (int k = 0; k < K; k++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		// 자를 수 있는
		spots = set.stream().mapToInt(Integer::intValue).toArray();
		Arrays.sort(spots);
		
		for (int c = C - 1; c > 0; c--) {
			binarySearch(c * unit);
		}
		
	}
	
	static int binarySearch(int target) {
		int start = 0;
		int end = spots.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			
		}
		return end; 
	}

}
