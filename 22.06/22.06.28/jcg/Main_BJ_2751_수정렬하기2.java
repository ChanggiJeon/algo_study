import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_BJ_2751_수정렬하기2 {
	/**
	 * 
	 * 1. 입력값을 int n 으로 받고 난뒤에 배열에 넣는다 -> 24ms정도 늦음
	 * 2. Arrays.sort는 최악의 경우 N^2, Collections.sort는 최악의 경우 NlogN; -> Collection이 56ms정도 빠름
	 * 3. PriorityQueue의 경우, 입력 NlogN, 반환 NlogN으로 2NlogN -> 따라서 제일 늦은 1920ms가 나왔음.
	 * 시간 참조 : https://www.grepiu.com/post/9
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0; i<N; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(arr);
		for(int i=0; i<arr.size(); i++) {
			sb.append(arr.get(i)+"\n");
		}
		System.out.print(sb);
	}
}
