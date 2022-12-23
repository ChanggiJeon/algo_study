import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_2042_구간합구하기 {
	
	static int N, M, K;
	static long number[];
	static long tree[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		number = new long[N+1];
		tree = new long[N*4];
		
		for(int i=1; i<=N; i++) {
			number[i] = Long.parseLong(br.readLine());
		}
		
		init(1, N, 1);
		
		for(int i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if(a == 1) {
				long diff = c - number[b];
				number[b] = c;
				update(1, N, 1, b, diff);
			}else if(a == 2) {
				sb.append(find(1, N, 1, b, (int)c) + "\n");
			}
		}
		System.out.print(sb);
	}

	private static void update(int treeStart, int treeEnd, int index, int target, long diff) {
		if(treeStart > target || target > treeEnd) {
			return;
		}
		tree[index] += diff;
		if(treeStart != treeEnd) {
			int mid = (treeStart + treeEnd) / 2;
			update(treeStart, mid, index*2, target, diff);
			update(mid+1, treeEnd, index*2+1, target, diff);
		}
	}

	private static long find(int treeStart, int treeEnd, int index, int requireStart, int requireEnd) {
		if(treeStart > requireEnd || requireStart > treeEnd) {
			return 0;
		}
		if(requireStart <= treeStart && treeEnd <= requireEnd) {
			return tree[index];
		}
		int mid = (treeStart + treeEnd) / 2;
		
		return find(treeStart, mid, index*2, requireStart, requireEnd) 
				+ find(mid+1, treeEnd, index*2+1, requireStart, requireEnd);
	}

	private static long init(int treeStart, int treeEnd, int index) {
		if(treeStart == treeEnd) {
			return tree[index] = number[treeStart];
		}
		int mid = (treeStart + treeEnd) / 2;
		
		return tree[index] = init(treeStart, mid, index*2) + init(mid+1, treeEnd, index*2+1);
	}
}



