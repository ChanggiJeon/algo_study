class Solution_PG_최고의집합 {
    public int[] solution(int n, int s) {
    	int[] answer = new int[n];
        if(s>n){
            return new int[] {-1};
        }else {
        	int div = s%n;
        	int num = s/n;
        	for(int i=0; i<n; i++) {
        		if(i>n-div) {
        			answer[i] = num+1;
        		}else {
        			answer[i] = num;
        		}
        	}
        }
        return answer;
    }
}