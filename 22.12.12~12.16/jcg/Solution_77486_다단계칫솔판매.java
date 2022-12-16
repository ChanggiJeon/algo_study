import java.util.*;

class Solution_77486_다단계칫솔판매 {

	static HashMap<String, Integer> personIdx = new HashMap<>();
	static String[] parents;
	static int[] answer;
	
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
    	int peopleSize = enroll.length;
    	answer = new int[peopleSize];
    	parents = referral.clone();
    	
    	for(int i=0; i<peopleSize; i++) {
    		String name = enroll[i];
    		personIdx.put(name, i);
    	}
    	
    	int sellerSize = seller.length;
    	for(int i=0; i<sellerSize; i++) {
    		sumPrice(100*amount[i], seller[i]);
    	}
    	
        return answer;
    }

	private static void sumPrice(int salary, String name) {
		if(name.equals("-")) {
			return;
		}
		int tax = salary/10;
		int idx = personIdx.get(name);
		answer[idx] += salary - tax;
        if(tax >0){
            sumPrice(tax, parents[idx]);
        }
	}
}