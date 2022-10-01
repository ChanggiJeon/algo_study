import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_BJ_1715_카드정렬하기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int sum = 0;
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		while(pq.size() > 1) {
			int add = pq.poll() + pq.poll();
			sum += add;
			pq.add(add);
		}
		System.out.println(sum);
	}

}
