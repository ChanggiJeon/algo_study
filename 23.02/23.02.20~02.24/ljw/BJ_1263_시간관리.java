package A202302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1263_시간관리 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		PriorityQueue<int[]> pQue = new PriorityQueue<>((int[] o, int[] o2) -> {return o2[1] - o[1];});
		for(int i = 0 ; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			pQue.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		int time = 1000000, tt, end;
		while(!pQue.isEmpty()) {
			int[] now = pQue.poll();
			tt = now[0];
			end = now[1];
			if(end < time) time=end;
			time -= tt;
		}
		if(time < 0) {
			System.out.println(-1);
			return;
		}
		System.out.println(time);
	}

}
