import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_5107_마니또 {

	static int N, T;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		while(true) {
			T++;
			N = Integer.parseInt(br.readLine());
			parents = new int[N];
			for(int i=0; i<N; i++) {
				parents[i] = i;
			}
			
			if(N ==0) break;
			int idx = 0;
			
			HashMap<String, Integer> map = new HashMap<>();
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int[] number = new int[2];
				
				for(int j=0; j<2; j++) {
					String key = st.nextToken();
					int id = map.getOrDefault(key, -1);
					if(id == -1) {
						id = idx;
						map.put(key, idx++);
					}
					number[j] = id;
				}

				union(number[0], number[1]);
			}
			
			int cnt = 1;
			for(int i=1; i<N; i++) {
				if(union(parents[0], parents[i])) {
					cnt++;
				}
			}
			
			sb.append(T + " " + cnt+"\n");
		}
		System.out.print(sb);
	}
	
	private static int find(int a) {
		if(parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
	}
	
}
