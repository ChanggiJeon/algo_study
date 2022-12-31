package A202211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14938_서강그라운드 {
	/*
	public static class Node{
		int now, w;
		Node next;
		public Node(int now, Node next, int w) {
			this.now = now;
			this.next = next;
			this.w = w;
		}
	}
	*/
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[] V = new int[N+1];
		int[][] dist = new int[N+1][N+1];
		//Node[] adj = new Node[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N; i ++) {
			V[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i <= N; i++) {
			Arrays.fill(dist[i], 16);
			dist[i][i] = 0;
		}
		int f, t, w;
		while(R-->0) {
			st = new StringTokenizer(br.readLine());
			f = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			//adj[f] = new Node(t, adj[f], w);
			//adj[t] = new Node(f, adj[t], w);
			dist[f][t] = w;
			dist[t][f] = w;
		}
		
		for(int k = 1; k <= N; k++) {
			for(int s = 1; s <= N; s++) {
				for(int e = 1; e <= N; e++) {
					if(k==s || k==e || s==e)continue;
					if(dist[s][e] > dist[s][k] + dist[k][e])
						dist[s][e] = dist[s][k] + dist[k][e];
				}
			}
		}
		int ans = 0, tmp;
		for(int i = 1; i <= N; i++) {
			tmp = 0;
			for(int j = 1 ; j <= N; j++) {
				if(dist[i][j] <= M)
					tmp += V[j];
			}
			ans = Math.max(ans, tmp);
		}
		System.out.println(ans);
	}

}






