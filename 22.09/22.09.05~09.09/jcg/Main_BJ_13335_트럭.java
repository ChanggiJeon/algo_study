import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_13335_트럭 {
	static class Truck{
		int len;
		int weight;

		public Truck(int weight, int len) {
			super();
			this.weight = weight;
			this.len = len;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int sumWeight = 0;
		int time = 0;
		Queue<Truck> que = new LinkedList<Truck>();
		boolean[] truckExist = new boolean[w+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int weight = Integer.parseInt(st.nextToken());
			boolean check = false;
			
			//기존 트럭과 기존 트럭 무게가 한도를 초과하면?
			while(!que.isEmpty() && sumWeight + weight > L) {
				int size = que.size();
				for(int j=0; j<size; j++) {
					Truck o = que.poll();
					truckExist[o.len] = false;
					o.len--;
					//아직 다리를 못빠져 나감.
					if(o.len > 0) {
						que.add(new Truck(o.weight, o.len));
						truckExist[o.len] = true;
					//0이면 다리를 빠져나갔음.
					}else {
						sumWeight -= o.weight;
					}
				}
				time++;
				check = true;
			}
			//트럭이 진입해야하는데 기존 트럭이 있으면 1칸 전진
			if(truckExist[w]) {
				int size = que.size();
				for(int j=0; j<size; j++) {
					Truck o = que.poll();
					truckExist[o.len] = false;
					o.len--;
					if(o.len > 0) {
						que.add(new Truck(o.weight, o.len));
						truckExist[o.len] = true;
					}else {
						sumWeight -= o.weight;
					}
				}
				time++;
			//진입 위치 비어져 있으면 바로 진입
			}else {
				if(!check) {
					time++;
				}
			}
			que.add(new Truck(weight, w));
			truckExist[w] = true;
			sumWeight += weight;
		}
		while(!que.isEmpty()) {
			int size = que.size();
			for(int j=0; j<size; j++) {
				Truck o = que.poll();
				o.len--;
				if(o.len > 0) {
					que.add(new Truck(o.weight, o.len));
				}
			}
			time++;
		}
		System.out.println(time);
	}

}
