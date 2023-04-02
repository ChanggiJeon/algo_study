package A202302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1114_통나무자르기 {
	static int K, L, C;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[L+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < L; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		arr[L] = K;
		Arrays.sort(arr);
		System.out.println(binarySearch());
	}
	private static String binarySearch() {
		int min = 0, max = K, mid;
		String answer = "";
		int result;
		for(int i = 0; i < 30; i++) {
			mid = (min+max)/2;
			result = sliceWood(mid);
			if(result != -1) {
				answer = mid + " " + result;
				max = mid;
			}else {
				min = mid+1;
			}
		}
		return answer;
	}
	private static int sliceWood(int len) {
		int right = L, left = L, cnt = 0;
		while(left != 0 && cnt < C) {
			left--; //하나씩 왼쪽으로
			if(arr[right] - arr[left] > len) {
				if(right-left == 1)
					return -1; //len이 가장 큰 길이가 될 수 없음
				//잘라야하는 상황 최대길이보다 클 수 없음
				cnt++;
				left = right = left+1; //전단계에서 자름
			}	
		}
		//여기 왔다면 left는 0 이거나 cnt == C
		if(arr[right] - arr[left] > len || arr[left] > len) return -1;
		return arr[left];
	}
}
