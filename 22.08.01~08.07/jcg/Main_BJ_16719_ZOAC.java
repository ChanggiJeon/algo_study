import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Main_BJ_16719_ZOAC {
	/**
	 * 하나씩 선택해서 더하려니까 너무 복잡함..
	 * 1.하나씩 빼면서 완성시키자. -> 사전순 정렬이므로 TreeSet or PQ 등등 활용 가능.
	 * pq -> 200ms / TreeSet -> 208ms -> pq가 조금 더 빠름.
	 * 2.dfs먼저 돌고, sb.append하면 순서가 역순으로 출력됨.
	 * 3.String은 불변객체이므로 메모리 낭비를 줄이기 위해 Stringbuilder 사용
	 */
	
	static StringBuilder ans = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		dfs(input, input.length());
		ans.append(input);
		System.out.println(ans);
	}

	private static void dfs(String inputString, int stringLength) {
		if(stringLength <= 1) {
			return;
		}
		
		int size = inputString.length();
		PriorityQueue<String> set = new PriorityQueue<String>();
		StringBuilder sb;
		
		for(int i=0; i<size; i++) {
			sb = new StringBuilder();
			for(int j=0; j<size; j++) {
				if(i==j) continue;
				sb.append(inputString.charAt(j));
			}
			set.add(sb.toString());
		}
		
		String subString = set.poll();
		dfs(subString, stringLength-1);
		ans.append(subString+"\n");
	}
}
