import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BJ_10866_덱 {
	static Deque<Integer> que = new LinkedList<Integer>();
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push_front":
				int n = Integer.parseInt(st.nextToken());
				que.addFirst(n);
				break;
			case "push_back":
				n = Integer.parseInt(st.nextToken());
				que.addLast(n);
				break;
			case "pop_front":
				if(que.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(que.pollFirst()).append("\n");
				}
				break;
			case "pop_back":
				if(que.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(que.pollLast()).append("\n");
				}
				break;
			case "size":
				sb.append(que.size()).append("\n");
				break;
			case "empty":
				if(que.isEmpty()) {
					sb.append(1).append("\n");
				}else sb.append(0).append("\n");
				break;
			case "front":
				if(que.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(que.peekFirst()).append("\n");
				}
				break;
			case "back":
				if(que.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(que.peekLast()).append("\n");
				}
				break;
			}
		}
		System.out.println(sb);
	}
}
