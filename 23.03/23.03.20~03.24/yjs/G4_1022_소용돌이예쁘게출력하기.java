package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_1022_소용돌이예쁘게출력하기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		int newMap[][] = new int[r2-r1+1][c2-c1+1];
		int maxNum = 0;
		for (int i = 0; i < newMap.length; i++) {
			for (int j = 0; j < newMap[0].length; j++) {
				int r = r1 + i;
				int c = c1 + j;
				int value = Math.max(Math.abs(r), Math.abs(c));
				int length = value * 2 + 1;
				int num = length * length;
				if (r == value) {
					newMap[i][j] = num - length / 2 + c;
				}
				else if (c == -value) {
					newMap[i][j] = num - length + 1 - length / 2 + r;
				}
				else if (r == -value) {
					newMap[i][j] = num - (length - 1) * 2 - length / 2 - c;
				}
				else {
					newMap[i][j] = num - (length - 1) * 3 - length / 2 - r;
				}
				maxNum = Math.max(newMap[i][j], maxNum);
			}
		}
		StringBuffer sb = new StringBuffer();
		int maxCnt = 0;
		while (maxNum > 0) {
			maxNum /= 10;
			maxCnt += 1;
		}
		for (int i = 0; i < newMap.length; i++) {
			for (int j = 0; j < newMap[0].length; j++) {
				int nowCnt = 0;
				int  nowValue = newMap[i][j];
				String empty = "";
				while (nowValue > 0) {
					nowValue /= 10;
					nowCnt += 1;
				}
				for (int k = 0; k < (maxCnt - nowCnt); k ++) {
					empty += " ";
				}
				sb.append(empty + Integer.toString(newMap[i][j]) + " ");
			}
			sb.toString().trim();
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
}
