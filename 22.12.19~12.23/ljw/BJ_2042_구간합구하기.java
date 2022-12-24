package A202211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2042_구간합구하기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int MK = Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken());
		int num = 1;
		while(num < N) {
			num*=2;
		}//num>=N
		int len = num+num;
		SegmentTree stree = new SegmentTree(len);
		
		long[] arr = new long[num];
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		stree.insert(arr, num);
		int a,b;
		long c;
		while(MK-->0) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Long.parseLong(st.nextToken());
			if(a==1) stree.change(b-1,c);
			else sb.append(stree.sum(1,1,num,b,(int)c)+"\n");
		}
		System.out.println(sb);
	}
	static class SegmentTree{
		long[] list;
		long len;
		int num;
		SegmentTree(long len){
			list = new long[(int) len];
			this.len = len;
		}
		
		public long sum(int idx, int s, int e, int l, int r) {
			if(l<=s&&e<=r)return list[idx];
			else if(l>e||r<s)return 0;
			int m = (s+e)/2;
			return sum(idx*2,s,m,l,r) + sum(idx*2+1,m+1,e,l,r);
		}

		public void change(int b, long c) {
			int idx = num + b;
			long diff = c - list[idx];
			for(int x = idx/2; x >= 1; x/=2) {
				list[x]+=diff;
			}
			list[idx] = c;
		}

		public void insert(long[] arr, int num) {
			this.num = num;
			System.arraycopy(arr, 0, list, num, num);
			init();
		}
		
		public void init() {
			long add = 0;
			for(int i = num; i < len; i++) {
				add = list[i];
				if(add != 0) {
					for(int x = i/2; x >= 1; x/=2) {
						list[x]+=add;
					}
				}
			}
		}
	}
}
	