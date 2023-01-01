import java.util.Arrays;

public class Solution_42861_섬연결하기 {

	public static void main(String[] args) {
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		int ans = solution(4, costs);
		System.out.println(ans);
	}
	
	static class Island implements Comparable<Island>{
		int from, to, cost;

		public Island(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Solution_42861_섬연결하기.Island o) {
			return this.cost - o.cost;
		}
		
	}
	static int N;
	static int[] parents;
	static Island[] Edge;
    public static int solution(int n, int[][] costs) {
    	N = n;
    	parents = new int[N];
    	int size = costs.length;
    	Edge = new Island[size];
    	
    	for(int i=0; i<N; i++) {
    		parents[i] = i;
    	}
    	
    	for(int i=0; i<size; i++) {
    		Edge[i] = new Island(costs[i][0], costs[i][1], costs[i][2]);
    	}
    	Arrays.sort(Edge);
    	
    	int cnt = 0;
    	int answer = 0;
    	for(int i=0; i<size; i++){
    		Island o = Edge[i];
    		if(union(o.from, o.to)) {
    			answer += o.cost;
    		}else {
    			continue;
    		}
    		cnt ++;
    		if(cnt == N) {
    			break;
    		}
    	}
        return answer;
    }
    
    public static int find(int a) {
    	if(parents[a] == a) {
    		return a;
    	}
    	return parents[a] = find(parents[a]);
    }
    
    public static boolean union(int a, int b) {
    	int RootA = find(a);
    	int RootB = find(b);
    	if(RootA == RootB) {
    		return false;
    	}
    	parents[RootA] = RootB;
    	return true;
    }
}
