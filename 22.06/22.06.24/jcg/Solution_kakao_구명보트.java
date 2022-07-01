package Kakao;
class Solution_kakao_구명보트 {
    public int solution(int[] people, int limit) {
    	/**
    	 * 
    	 * 1. 2명이 최대임!!!!! (문제를 잘 읽자..)
    	 * 
    	 */
        
        int length = people.length;
        int[] weight = new int[241];
        for(int i=0; i<length; i++){
            weight[people[i]]++;
        }
        int answer = 0;
        int cnt = 0;
        for(int i=0; i<length; i++){
            if(cnt>=length){
                break;
            }
            int sum = 0;
            int max = 0;
            for(int j=240; j>=40; j--){
                if(weight[j]>0 && sum+j<=limit){
                    if(max>=2){
                        break;   
                    }
                    sum += j;
                    weight[j]--;
                    cnt++;
                    max++;
                    if(weight[j]>0){
                        j++;
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}