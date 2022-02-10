import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_14501_퇴사 {
	static class plan implements Comparable<plan>{
		int startDay, finishDay, price;

		public plan(int startDay, int finishDay, int price) {
			super();
			this.startDay = startDay;
			this.finishDay = finishDay;
			this.price = price;
		}

		@Override
		public int compareTo(Main_BJ_14501_퇴사.plan o) {
			if(this.finishDay == o.finishDay) {
				return o.price - this.price;
			}
			return this.finishDay - o.finishDay;
		}
		
	}
	static plan[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		list = new plan[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			list[i] = new plan(i,i+d,p);
		}
		
		//끝나는 day가 빠른순으로 sort, 끝나는 day가 같으면 price가 높은 순
		Arrays.sort(list);
		
		//DP[i]는 i날짜까지 마감 가능한 최대의 price를 뜻함.
		int[] DP = new int[n+1];
		//모든 작업은 1일 이상 걸리므로 1일에 바로 끝나는 작업은 없음.
		DP[1] = 0;
		
		//1일~ n일까지 마감 해야함.
		for(int i=1; i<=n; i++) {
			//일감이 0~n까지 있음.
			for(int j=0; j<n; j++) {
				//마감이 i일 이하여야함
				if (list[j].finishDay <= i) {
					//그중에서 최대를 구함. DP[start]에 price를 더한게 DP[i]보다 크면 j번째 일을 하는게 최고 효율이므로 갱신.
					if (DP[list[j].startDay] + list[j].price > DP[i]) {
						DP[i] = DP[list[j].startDay] + list[j].price;
					}
					//마감일 넘으면 뒤에는 볼것도 없음. sort했으므로.
				}else {
					break;
				}
			}
		}
		int ans = 0;
		for(int i=1; i<=n; i++) {
			ans = Math.max(ans, DP[i]);
		}
		System.out.println(ans);

	}

}
