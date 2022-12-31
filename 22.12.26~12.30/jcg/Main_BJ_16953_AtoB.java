import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16953_AtoB {

	static int A, B;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> que = new LinkedList<>();
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		que.add(B);
		int cnt = 1;
		boolean flag = false;

		o:while(!que.isEmpty()) {
			int size = que.size();
			for(int i=0; i<size; i++) {
				int o = que.poll();
				if(o == A) {
					System.out.println(cnt);
					flag = true;
					break o;
				}
                if(o < A){
                    continue;
                }
				if(o%2==0) {
					que.add(o/2);
				}
				if(o%10==1) {
					que.add(o/10);
				}
			}
			cnt++;
		}
		if(!flag) {
			System.out.print(-1);
		}
	}
}
