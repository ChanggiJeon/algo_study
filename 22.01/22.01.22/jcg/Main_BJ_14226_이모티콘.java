import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_BJ_14226_이모티콘 {
	static class clipboard{
		int num, save;

		public clipboard(int num, int save) {
			super();
			this.num = num;
			this.save = save;
		}
		
	}
	static boolean visited[][] = new boolean[2000][1000];
	static int goal, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		goal = Integer.parseInt(br.readLine());
		
		progress();
		System.out.println(ans);
	}

	private static void progress() {
		Queue<clipboard> que = new LinkedList();
		que.add(new clipboard(1,0));
		int time = 0;
		visited[1][0] = true;
		
		o: while(!que.isEmpty()) {
			int depth = que.size();
			for (int i = 0; i < depth; i++) {
				clipboard o = que.poll();
				if (o.num == goal) {
					ans = time;
					break o;
				}
				// 화면 복사
				if (bcheck(o.num, o.num) && !visited[o.num][o.num]) {
					que.add(new clipboard(o.num, o.num));
					visited[o.num][o.num] = true;
				}
				// 붙여넣기
				if (bcheck(o.num + o.save, o.save) && !visited[o.num + o.save][o.save]) {
					que.add(new clipboard(o.num + o.save, o.save));
					visited[o.num + o.save][o.save] = true;
				}
				// 화면의 이모티콘 1개씩 제거
				if (bcheck(o.num - 1, o.save) && !visited[o.num - 1][o.save]) {
					que.add(new clipboard(o.num - 1, o.save));
					visited[o.num - 1][o.save] = true;
				}
			}
			time++;
		}
	}

	private static boolean bcheck(int num, int save) {
		return num>0 && num<2000 && save<1000;
	}
}
