import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_1764_듣보잡 {
	
	static int N, M;
	static HashSet<String> nameList = new HashSet<String>();
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		PriorityQueue<String> que = new PriorityQueue<String>();
		
		for(int i=0; i<N; i++) {
			nameList.add(br.readLine());
		}
		for(int j=0; j<M; j++) {
			String name = br.readLine();
			if(nameList.contains(name)) {
				que.add(name);
			}
		}
		sb.append(que.size()+"\n");
		while(!que.isEmpty()) {
			sb.append(que.poll()+"\n");
		}
		System.out.print(sb);
	}

}
