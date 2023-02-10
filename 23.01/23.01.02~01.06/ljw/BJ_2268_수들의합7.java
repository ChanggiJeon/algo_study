package A202301;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2268_수들의합7 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int num = 1;
		while(num < N) {
			num*=2;
		}
		SegmentTree stree = new SegmentTree(num);
		int a,b,c;
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			if(a==1) {
				stree.change(--b, c);
			}else {
				if(b>c) {
					int tmp = c;
					c = b;
					b = tmp;
				}
				sb.append(stree.sum(1, 0, num-1, --b, --c)+"\n");
			}
		}
		System.out.println(sb);
	}
	static class SegmentTree{
		long[] list;
		int leaf;
		
		SegmentTree(int len){
			list = new long[len+len];
			this.leaf = len;
		}
		
		public long sum(int idx, int s, int e, int l, int r) {
			if(l<=s&&e<=r)return list[idx];
			else if(l>e||r<s)return 0;
			int m = (s+e)/2;
			return sum(idx*2,s,m,l,r) + sum(idx*2+1,m+1,e,l,r);
		}
		public void change(int b, long c) {
			int idx = leaf + b;
			long diff = c - list[idx];
			for(int x = idx/2; x >= 1; x/=2) {
				list[x]+=diff;
			}
			list[idx] = c;
		}

	}
}
	