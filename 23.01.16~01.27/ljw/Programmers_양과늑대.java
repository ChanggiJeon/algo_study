package A202301;

import java.util.*;

public class Programmers_양과늑대 {

	public static void main(String[] args) {
		int[] info = new int[] {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
		int[][]	edges = new int[][] {
			{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}
					};
		System.out.println(solution(info,edges));
	}
	static List<Integer>[] go;
	static int[] inf;
	static int max=0;
	public static int solution(int[] info, int[][] edges) {
		categoryzation(edges, info.length);
		inf = info.clone();
		dfs(0, 1, 0, 1);
		return max;
	}
	private static void dfs(int now, int acc, int mask, int cnt) {
		max = Math.max(cnt, max);
		for(int t : go[now]) {
			mask = mask | (1<<t);
		}
		String str = "";
		for(int i = 0; i < 17; i++ ) {
			if((mask&(1<<i)) != 0) str=1+str;
			else str=0+str;
		}
		System.out.println(now + " #### " + acc + " #### " + str + " #### " + cnt + " #### ");
		int nextMask;
		for(int i = 0; i < 17; i++ ) {
			if((mask&(1<<i)) != 0) {
				if(inf[i] == 0) {
					System.out.println("sheep: "+now+" to "+ i);
					nextMask = mask-(1<<i);
					str = "";
					for(int k = 0; k < 17; k++ ) {
						if((mask&(1<<k)) != 0) str=1+str;
						else str=0+str;
					}
					System.out.println(str);
					dfs(i, acc+1, nextMask, cnt+1);
				}
				else if(acc > 1) {
					System.out.println("wolf: "+now+" to "+ i);
					nextMask = mask-(1<<i);
					str = "";
					for(int k = 0; k < 17; k++ ) {
						if((mask&(1<<k)) != 0) str=1+str;
						else str=0+str;
					}
					System.out.println(str);
					dfs(i, acc-1, nextMask, cnt);
				}
			}
		}
	}
	public static void categoryzation(int[][]edges, int n){
		go = new List[n];
		for(int i = 0; i < n; i++)go[i] = new ArrayList<>();
		for(int[] e : edges) {
			go[e[0]].add(e[1]);
		}
	}
}
