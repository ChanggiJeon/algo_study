package A202211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16953_AtoB_v2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int cnt = 1;
		while(B > A) {
			if(B%10==1) { B/=10;cnt++;}
			else if(B%2==0) { B/=2; cnt++;}
			else break;
		}
		System.out.println(A==B?cnt:-1);
	}

}
