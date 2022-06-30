import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_18870_좌표압축 {
	static class Number implements Comparable<Number>{
		int num;
		int idx;
		public Number(int num, int idx) {
			super();
			this.num = num;
			this.idx = idx;
		}
		@Override
		public int compareTo(Main_BJ_18870_좌표압축.Number o) {
			return this.num -o.num;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[N];
		
		PriorityQueue<Number> que = new PriorityQueue<Main_BJ_18870_좌표압축.Number>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(st.nextToken());
			que.add(new Number(n, i));
		}
		Number start = que.poll();
		int cnt = 0;
		int before = start.num;
		count[start.idx] = cnt;
		
		while(!que.isEmpty()) {
			Number o = que.poll();
			if(o.num == before) {
				count[o.idx] = cnt;
			}else {
				before = o.num;
				count[o.idx]= ++cnt;
			}
		}
		for(int i=0; i<N; i++) {
			sb.append(count[i]+" ");
		}
		System.out.println(sb);
	}
}
