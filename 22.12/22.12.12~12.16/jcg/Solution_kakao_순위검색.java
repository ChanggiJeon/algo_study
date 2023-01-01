import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Solution_kakao_순위검색 {
	
static HashMap<String, ArrayList<Integer>> hashmap = new HashMap<String, ArrayList<Integer>>();
	
	public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        HashMap<String, Boolean> sorted = new HashMap<String, Boolean>();
        int cnt = 0;
        
        for(int i=0; i<info.length; i++) {
        	String[] input = info[i].split(" ");
        	int point = Integer.parseInt(input[4]);
        	dfs(input, 0, new int[4], point);
        }
        
        for(int i=0; i<query.length; i++) {
        	String[] input = query[i].split(" and ");
        	int point = Integer.parseInt(input[3].split(" ")[1]);
        	input[3] = input[3].split(" ")[0];
        	
        	StringBuilder sb = new StringBuilder();
        	for(int j=0; j<4; j++) {
    			sb.append(input[j]);
        	}
        	
        	String order = sb.toString();
        	ArrayList<Integer> arr = hashmap.get(order);
        	if(arr == null) {
        		answer[cnt++] = 0;
        	}else {
        		if(sorted.get(order) == null) {
        			Collections.sort(arr);
        			sorted.put(order, true);
        		}
        		int ans = binarySearch(arr, point) ;
        		answer[cnt++] = ans;
        	}
        }
		return answer;
    }
	private static int binarySearch(ArrayList<Integer> arr, int goal) {
		int max = arr.size()-1;
		int min = 0;
		int mid = (max+min)/2;
		while(max>=min) {
			mid = (max+min)/2;
			if(arr.get(mid) == goal) {
				while(true) {
					if(mid >= 0 && arr.get(mid) == goal) {
                        mid -= 1;
					}else {
						mid += 1;
						break;
					}
				}
                return arr.size() - mid;
			}else if(arr.get(mid) > goal) {
				max = mid-1;
			}else {
				min = mid+1;
			}
		}
		return arr.size() - min;
	}
	private static void dfs(String[] input, int cnt, int[] pick, int point) {
		if(cnt == 4) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<4; i++) {
				if(pick[i] == 0) {
					sb.append("-");
				}else {
					sb.append(input[i]);
				}
			}
			ArrayList<Integer> arr = hashmap.get(sb.toString());
			if(arr == null) {
				arr = new ArrayList<Integer>();
			}
        	arr.add(point);
        	hashmap.put(sb.toString(), arr);
			return;
		}
		
		pick[cnt] = 0;
		dfs(input, cnt+1, pick, point);
		pick[cnt] = 1;
		dfs(input, cnt+1, pick, point);
	}
}
