package A202304;

import java.util.*;

class Solution3 {
    
    public int solution(int n, int[] cores) {
        int left = 1;
        int right = 500000000 / (n - cores.length);
        int mid, cnt, preWork = 0;
        while(left < right){
            mid = (left + right) / 2;
            cnt = getCount(mid, cores);
            if(cnt >= n){
                right = mid;
            }else{// cnt < n
                preWork = cnt;
                left = mid+1;
            }
        }
        
        //left >= right
        //cnt 전시간까지 작업량
        int remain = n - preWork;
        for(int i = 0; i < cores.length; i++){
            if(left%cores[i] == 0){
                remain--;
                if(remain == 0)return i+1;
            }
        }
        return -1;
    }
    
    public int getCount(int mid, int[] cores){
        int cnt = cores.length;
        for(int c : cores){
            cnt += mid/c;
        }
        return cnt;
    }
}