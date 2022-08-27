import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_11000_강의실배정 {

	static class Class implements Comparable<Class>{
		int end, start;
		public Class(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Main_BJ_11000_강의실배정.Class o) {
			if(this.start == o.start) {
				return o.end - this.end;
			}
			return this.start - o.start;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Class[] list = new Class[N];

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[i] = new Class(start, end);
		}
		Arrays.sort(list);
		
		int ans = 0;
		
		PriorityQueue<Integer> que = new PriorityQueue<Integer>();
		que.add(list[0].end);
		for(int i=1; i<N; i++) {
			if(que.peek()<=list[i].start) {
				que.poll();
				que.add(list[i].end);
			}else {
				que.add(list[i].end);
			}
		}
		System.out.println(que.size());
	}

}
