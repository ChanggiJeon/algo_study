import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_2693_N번째큰수 {
	/**
	 * 
	 * 1. bubble sort -> 184ms
	 * 2. select sort -> 188ms
	 * 3. array sort -> 180ms
	 * 4. priorityQueue -> 192ms
	 * 
	 */

	static int[] arr = new int[10];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			PriorityQueue<Integer> que = new PriorityQueue<Integer>(Collections.reverseOrder());
			for(int i=0; i<10; i++) {
//				arr[i] = Integer.parseInt(st.nextToken());
				que.add(Integer.parseInt(st.nextToken()));
			}
//			Arrays.sort(arr);
//			bubble(arr);
//			select(arr);
			que.poll();
			que.poll();
			sb.append(que.poll()+"\n");
		}
		System.out.println(sb);
	}

	private static void select(int[] arr) {
		for(int i=0; i<10; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			for(int j=i; j<10; j++) {
				if(min > arr[j]) {
					min = arr[j];
					idx = j;
				}
			}
			int temp = arr[i];
			arr[i] = min;
			arr[idx] = temp;
		}
	}

	private static void bubble(int[] arr) {
		for(int i=0; i<10; i++) {
			int cur = 9;
			while(cur>0) {
				if(arr[cur-1]>arr[cur]) {
					int temp = arr[cur-1];
					arr[cur-1] = arr[cur];
					arr[cur] = temp;
				}
				cur--;
			}
		}
		
	}
}
