import java.util.*;

public class Solution_PG_큰수만들기 {

	public static void main(String[] args) {
		String number = "432";
		int k = 2;
		
		StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int curIdx = 0;
        int nextIdx = 1;
        int current = number.charAt(curIdx) - '0';
        int next = number.charAt(nextIdx) - '0';
        boolean[] visited = new boolean[number.length()];
        
        o : while(true){
        	// 다음 수가 현재 수보다 크면
            while(current < next){
            	// 제외할 수에 넣어져 있지 않다면 넣고 cnt++;
            	if(!visited[curIdx]) cnt++;
            	visited[curIdx] = true;
            	// cnt가 k개 달성하면 종료
                if(cnt >= k) break o;
                // 0까지 계속 현재 수를 줄여가면서 비교
                if(--curIdx < 0 ) break;
                current = number.charAt(curIdx) - '0';
            }
            // 다음 수 넘김
            nextIdx++;
            // 다음 수가 없다면, 뒤에서 나머지 만큼 뺌.
            if(nextIdx == number.length()) {
            	while(cnt != k) {
            		visited[--nextIdx] = true;
            		cnt ++;
            	}
            	break o;
            }
            // 현재 수는 다음수 - 1로 갱신
            next = number.charAt(nextIdx) - '0';
            curIdx = nextIdx - 1;
            current = number.charAt(curIdx) - '0';
        }
    
        for(int i=0; i<number.length(); i++){
            if(!visited[i]){
                sb.append(number.charAt(i));
            }
        }
       	System.out.println(sb.toString());

	}

}
