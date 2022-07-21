import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BJ_1931_회의실배정 {
	/**
	 * 
	 * 회의 시작과 끝나는 시간이 같을 수도 있다!!
	 * 끝나는 시간이 같다면, 시작시간이 빠른 순부터 해봐야함.(조건이 불리한 순서부터)
	 *
	 */
	static class Lecture implements Comparable<Lecture>{
		int start, end;

		public Lecture(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Main_BJ_1931_회의실배정.Lecture o) {
			if(this.end == o.end) {
				return this.start - o.start;
			}
			return this.end - o.end;
		}
	}

	static Lecture[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		list = new Lecture[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[i] = new Lecture(start, end);
		}
		Arrays.sort(list);
		int end = list[0].end;
		int ans = 1;
		for(int i=1; i<n; i++) {
			if(list[i].start >= end) {
				end = list[i].end;
				ans += 1;
			}
		}
		System.out.println(ans);
	}

}
