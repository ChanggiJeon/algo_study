import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_BJ_16964_DFS스페셜저지 {
	/**
	 * HashMap<Integer, Arraylist<integer>>의 자료구조일때는,
	 * 1,2
	 * 1,3
	 * 1,4
	 * ... 1,100000
	 * 일때 contains() 메소드가 10000만개씩 돌면서 찾아야해서 73%에서 시간초과가 뜬다.
	 * HashSet으로 바꿔주면 contains가 일일이 다 돌면서 찾는게 아닌 key값으로 바로 찾아오므로 통과! 
	 */
	
	static int N;
	static boolean[] visited;
	static HashMap<Integer, HashSet<Integer>> list;
	static int[] ans;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		list = new HashMap<Integer, HashSet<Integer>>();
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			list.put(i, new HashSet<Integer>());
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list.get(to).add(from);
			list.get(from).add(to);
		}
		
		ans = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			ans[i] = Integer.parseInt(st.nextToken());
		}
		if(ans[0]!= 1) {
			System.out.println(0);
		} else {
			visited[1] = true;
			dfs(1, 1);
			System.out.println(0);
		}
	}

	private static int dfs(int num, int cnt) {
		if(cnt==N) {
			System.out.println(1);
			System.exit(0);
			return 0;
		}
		
		HashSet<Integer> Arr = list.get(num);
		int n = ans[cnt];
		for (int i = 0; i < Arr.size(); i++) {
			if (Arr.contains(n) && !visited[n]) {
				visited[n] = true;
				cnt = dfs(n, cnt + 1);
				n = ans[cnt];
			}
		}
		
		return cnt;
	}
}
