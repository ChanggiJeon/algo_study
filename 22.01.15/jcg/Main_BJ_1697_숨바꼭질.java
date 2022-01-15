import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1697_숨바꼭질 {
	static int N, K;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(N);
		boolean[] visited = new boolean[100001];
		int time = 0;
		
		while(!que.isEmpty()) {
			int depth = que.size();
			for(int i=0; i<depth; i++) {
				int out = que.poll();
				if(out == K) return time;
				
				if(out+1<=100000 && !visited[out+1]) {
					visited[out+1] = true;
					que.add(out+1);
				}
				if(out-1>=0 && !visited[out-1]) {
					visited[out-1] = true;
					que.add(out-1);
				}
				if(out*2<=100000 && !visited[out*2]) {
					visited[out*2] = true;
					que.add(out*2);
				}
			}
			time++;
		}
		return 0;
	}
}
