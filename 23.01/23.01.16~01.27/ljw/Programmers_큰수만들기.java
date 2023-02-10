package A202301;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Programmers_큰수만들기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number = br.readLine();
		int k = Integer.parseInt(br.readLine());
		System.out.println(solution(number, k));
	}

	
    public static String solution(String number, int k) {
        int start = 0;
        int maxIndex = 0;
        while(k > 0 && number.length() > start+k){
            maxIndex = findMaxIndexInLange(number, start, start+k);
            if(start < maxIndex){
                number = number.substring(0, start) + number.substring(maxIndex);
                k -= maxIndex - start;
            }
            start++;
        }
        if(k!=0)number=number.substring(0, number.length()-k);
        return number;
    }
    public static int findMaxIndexInLange(String number, int start, int end){
        int maxIndex = start;
        int maxValue = number.charAt(start);
        for(int i = start+1; i <= end; i++){
            if(maxValue < number.charAt(i)){
                maxIndex = i;
                maxValue = number.charAt(i);
            }
        }
        return maxIndex;
    }

}
