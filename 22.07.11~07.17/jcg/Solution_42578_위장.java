import java.util.ArrayList;
import java.util.HashMap;

class Solution_42578_위장 {
	static int answer;
	static int size;
	static int[] list;
	
    public int solution(String[][] clothes) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
    	for(int i=0; i<clothes.length; i++) {
    		if(map.containsKey(clothes[i][1])) {
    			map.put(clothes[i][1], map.get(clothes[i][1])+1);
    		}else {
    			map.put(clothes[i][1], 1);
    		}
    	}
    	size = map.size();
    	list = new int[size];
    	int cnt = 0;
    	for(String k: map.keySet()) {
    		list[cnt++] = map.get(k);
    	}
    	dfs(0, 0, 1, 0);
        return answer;
        
    }

	private void dfs(int cnt, int start, int sum, int flag) {
		if(cnt>size) {
			return;
		}
		for(int i= start; i<size; i++) {
			if((flag&1<<i)!=0) {
				continue;
			}else {
				answer += (sum*list[i]);
				dfs(cnt+1, i, sum*list[i], flag|1<<i);
			}
		}
	}
}