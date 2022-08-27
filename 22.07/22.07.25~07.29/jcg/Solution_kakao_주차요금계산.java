package Kakao;
import java.util.HashMap;
import java.util.TreeMap;

class Solution_kakao_주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
    	
    	HashMap<String, Integer> carInTime = new HashMap<String, Integer>();
    	HashMap<String, Boolean> isParking = new HashMap<String, Boolean>();
    	TreeMap<String, Integer> carSumTime = new TreeMap<String, Integer>();
    	
    	for(int i=0; i<records.length; i++) {
    		String[] input = records[i].split(" ");
    		int time = Integer.parseInt(input[0].split(":")[0])*60 
    				+ Integer.parseInt(input[0].split(":")[1]);
    		String carNumber = input[1];
    		String order = input[2];
    		
    		if("IN".equals(order)) {
    			isParking.put(carNumber, true);
    			carInTime.put(carNumber, time);
    		}else {
    			isParking.put(carNumber, false);
    			int carIn = carInTime.get(carNumber);
    			carSumTime.put(carNumber, time-carIn+carSumTime.getOrDefault(carNumber, 0));
    		}
    	}
    	
    	for(String key : isParking.keySet()) {
    		if(isParking.get(key)) {
    			int carIn = carInTime.get(key);
    			carSumTime.put(key, (23*60+59)-carIn+carSumTime.getOrDefault(key, 0));
    		}
    	}
    	
    	int[] answer = new int[carInTime.size()];
    	
    	int idx = 0;
    	for(int time : carSumTime.values()) {
    		int totalTime = time-fees[0];
			int totalFee = totalTime>0? fees[1] + (int)Math.ceil(totalTime/(double)fees[2]) * fees[3] : fees[1];
			answer[idx++] = totalFee;
    	}
        return answer;
    }
}
