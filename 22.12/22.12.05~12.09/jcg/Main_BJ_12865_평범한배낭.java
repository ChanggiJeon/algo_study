import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_12865_평범한배낭 {
	static class Item implements Comparable<Item>{
		int weight, price;

		public Item(int weight, int price) {
			super();
			this.weight = weight;
			this.price = price;
		}

		@Override
		public int compareTo(Main_BJ_12865_평범한배낭.Item o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] DP = new int[N+1][K+1];
		Item[] items = new Item[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			items[i] = new Item(w, p);
		}
		Arrays.sort(items);
		
		for(int i=1; i<=N; i++) {
			Item pick = items[i-1];
			int weight = pick.weight;
			for(int w=1; w<=K; w++) {
				if(w >= weight) {
					DP[i][w] = Math.max(DP[i-1][w-weight]+pick.price, DP[i-1][w]);
				}else {
					DP[i][w] = Math.max(DP[i-1][w], DP[i][w-1]);
				}
			}
		}
		System.out.println(DP[N][K]);
	}
}
