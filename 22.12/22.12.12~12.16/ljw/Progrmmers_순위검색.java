/*
 import java.util.*;

class Solution {
    Map<String, Integer> map;
    Map<Integer,int[]> division;
    public int[] solution(String[] info, String[] query) {
        map = new HashMap<>();
        division = new HashMap<>();
        init();
        for(String in:info){
            String[] tmp = in.split(" ");
            insert(tmp);
        }
        int[] answer = new int[query.length];
        for(int i = 0 ; i < query.length; i++){
            String[] tmp = query[i].split(" and ");
            int key = tmp[0].equals("-") ? (1<<0) : map.get(tmp[0]);
            key += tmp[1].equals("-") ? (1<<4) : map.get(tmp[1]);
            key += tmp[2].equals("-") ? (1<<7) : map.get(tmp[2]);
            String[] ttmp = tmp[3].split(" ");
            key += ttmp[0].equals("-") ? (1<<10) : map.get(ttmp[0]);
            int[] arr = division.get(key);
            for(int score = Integer.parseInt(ttmp[1]); score < 100_001; score++){
                answer[i]+=arr[score];
            }
        }
        return answer;
    }
    public void insert(String[] tmp){
        int score = Integer.parseInt(tmp[4]);
        for(int a = 0; a < 2; a++){
            for(int b = 0; b < 2; b++){
                for(int c = 0; c < 2; c++){
                    for(int d = 0; d < 2; d++){
                        int key = a == 0 ? (1<<0) : map.get(tmp[0]);
                        key += b == 0 ? (1<<4) : map.get(tmp[1]);
                        key += c == 0 ? (1<<7) : map.get(tmp[2]);
                        key += d == 0 ? (1<<10) : map.get(tmp[3]);
                        division.get(key)[score]++;
                    }
                }   
            }      
        }
    }
    public void init(){
        map.put("cpp",(1<<1));      map.put("java",(1<<2));     map.put("python",(1<<3));
        map.put("backend",(1<<5));  map.put("frontend",(1<<6)); map.put("junior",(1<<8));
        map.put("senior",(1<<9));   map.put("chicken",(1<<11)); map.put("pizza",(1<<12));
        for(int a = 0; a < 4; a++){
            for(int b = 4; b < 7; b++){
                for(int c = 7; c < 10; c++){
                    for(int d = 10; d < 13; d++){
                        division.put((1<<a)+(1<<b)+(1<<c)+(1<<d), new int[100_001]);
                    }
                }
            }
        }
    }
    
} 
 */
 