import java.util.HashSet;

class Solution_42577_전화번호목록 {
	/**
	 * 
	 * 2중 for문 O(n^2)
	 * hashSet 이용시 전화번호 최대길이가 20이므로
	 * 입력 100만 O(n) + 20*100만 20*O(n)
	 * 
	 */
    public boolean solution(String[] phone_book) {
    	HashSet<String> set = new HashSet<String>();
    	for(int i=0; i<phone_book.length; i++) {
    		set.add(phone_book[i]);
    	}
    	for(int i=0; i<phone_book.length; i++) {
    		String check = phone_book[i];
    		int size = check.length();
    		for(int j=0; j<size; j++) {
    			if(set.contains(check.substring(0,j))) {
    				return false;
    			}
    		}
    	}

    	return true;
    }
}
