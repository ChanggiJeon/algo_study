package A202302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_2866_문자열잘라내기 {
	static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken())-1;
		int C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		br.readLine();
		for(int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		ArrayList<String> arr = new ArrayList<>();
		for(int j = 0 ; j < C; j++) {
			arr.add(map[R-1][j]+"");
		}
		Set<String> set = new HashSet<>(arr);
		if(set.size() == C) {
			System.out.println(R);
			return;
		}
		int cnt = 1;
		for(int i = R-2; i >= 0; i--) { //R-1번 반복
			for(int j = 0 ; j < C; j++) {
				arr.set(j, arr.get(j)+map[i][j]);
			}
			set = new HashSet<>(arr);
			if(set.size() == C) {
				System.out.println(R - cnt); //cnt의 최댓값은 R-1;
				return;
			}
			cnt++;
		}
		System.out.println(0);
	}

}













