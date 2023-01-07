import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2268_수들의합7 {
	
	static int N, M;
	static long[] number, tree;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		number = new long[N+1];
		tree = new long[N*4];
		init(1, N, 1);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			if(order == 0) {
				if(a > (int)b) {
					sb.append(find((int)b, a, 1, N, 1)+"\n");
				}else {
					sb.append(find(a, (int)b, 1, N, 1)+"\n");
				}
			}else {
				long diff = b - number[a];
				modify(1, N, 1, a, diff);
				number[a] = b;
			}
		}
		System.out.print(sb);
	}
	private static void modify(int cs, int ce, int index, int target, long diff) {
		if(cs > target || ce < target) {
			return;
		}
		tree[index] += diff;
		if(cs != ce) {
			int mid = (cs + ce) /2;
			modify(cs, mid, index*2, target, diff);
			modify(mid+1, ce, index*2+1, target, diff);
		}
	}
	private static long find(int fs, int fe, int cs, int ce, int index) {
		if(fs>ce || fe<cs) {
			return 0;
		}
		if(cs>=fs && ce<=fe) {
			return tree[index];
		}
		int mid = (cs + ce) /2;
		
		return find(fs, fe, cs, mid, index*2) + find(fs, fe, mid+1, ce, index*2+1);
	}
	
	
	private static long init(int start, int end, int index) {
		if(start == end) {
			return tree[index] = number[start];
		}
		int mid = (start + end) / 2;
		
		return tree[index] = init(start, mid, index*2)+ init(mid+1, end, index*2+1);
	}
}

