package A202211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_1759_암호만들기 {
	static int R, N;
	static char[] ch;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		ch = new char[N];
		for(int i = 0 ; i < N; i++){
			ch[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(ch);
		combination(0, 0, new char[R]);
		System.out.println(sb);
	}
	public static void combination(int r, int n, char[] chh){
		if(r >= R){
			String tmp = "";
			int cnt = 0;
			for(int i = 0 ; i < R; i++){
				tmp += chh[i];
				if(chh[i] == 'a' || chh[i] == 'e' || chh[i] == 'i' || chh[i] == 'o' || chh[i] == 'u'){
					cnt++;
				}
			}
			if(cnt >= 1 && R - cnt >= 2){
				sb.append(tmp+"\n");
			}
			return;
		}
		if(n >= N)return;
		chh[r] = ch[n];
		combination(r+1, n+1,chh);
		combination(r, n+1, chh);
	}
}
