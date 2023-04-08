package A202304;


import java.util.Arrays;

class Solution {
    
    public int solution(String name) {
        int answer = 0;
        int min = name.length()-1;
        int size = name.length();
        char memo = name.charAt(0);
        char now;
        boolean check = false;
        for(int i = 0 ; i < size; i++){
            now = name.charAt(i);
            if( now == 'A' && memo != now){
                int left = i-1;
                int right = 0;
                for(int j = i+1; j < size; j++){
                    if(name.charAt(j) != 'A'){
                        right = size - j;
                        break;
                    }
                }
                min = Math.min(min, (left>right ? left + right * 2 : left * 2 + right));
            }
            answer += 13- Math.abs( 78 - now);
            if(memo != now){
                memo = now;
                check = true;
            }
        }
        if(!check && memo == 'A')return 0;
        return answer + min;
    }
}
