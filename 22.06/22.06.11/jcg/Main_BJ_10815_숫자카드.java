import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_BJ_10815_숫자카드 {
	/**
	 * 
	 * 분할정복이라고 했는데, 풀어보니 자료구조..
	 * 
	 * HashMap -> 928ms / 135,020
	 * TreeSet -> 1284ms / 132,892
	 * Arrays -> 784ms / 116,568
	 * 
	 * boolean[] 1byte
	 * Boolean[] 4~20bytes
	 * BitSet 1bit
	 * 
	 * 속도 100만 개 기준
	 * boolean[] >> BitSet 4배정도 boolean[]가 빠르다.
	 * 
	 */

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
//		TreeSet<Integer> numberList = new TreeSet<Integer>();
//		HashMap<Integer, Boolean> numberList = new HashMap<Integer, Boolean>();
		int HALF = 10_000_000;
		boolean[] numberList = new boolean[20_000_000];
		Arrays.fill(numberList, false);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int number = Integer.parseInt(st.nextToken());
//			numberList.put(number, true);
//			numberList.add(number);
			numberList[number+HALF] = true;
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int searchNumber = Integer.parseInt(st.nextToken());
//			if(numberList.containsKey(searchNumber)) {
//				sb.append("1 ");
//			}else {
//				sb.append("0 ");
//			}
//			if(numberList.contains(searchNumber)) {
//				sb.append("1 ");
//			}else {
//				sb.append("0 ");
//			}
			if(numberList[searchNumber+HALF]) {
				sb.append("1 ");
			}else {
				sb.append("0 ");
			}
		}
		System.out.println(sb.toString().trim());
	}

}
