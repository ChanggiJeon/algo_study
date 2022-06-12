import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_16198_에너지모으기 {
	/**
	 * 1. 선택한 i 구슬을 자료구조에서 remove시킨다.
	 * 2. 선택한 i 구슬을 체크하면서 탐색한다.
	 * 
	 */
	static int N;
	static int MAX = Integer.MIN_VALUE;
	static int[] energyList;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		energyList = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			energyList[i] = Integer.parseInt(st.nextToken());
		}
		
		findMaxEnergy(0, 0, 0);
		System.out.println(MAX);
		
	}

	private static void findMaxEnergy(int cnt, int sum, int flag) {
		if(cnt == N-2) {
			if(sum > MAX) {
				MAX = sum;
			}
			return;
		}
		
		for(int i=1; i<N-1; i++) {
			if((flag&1<<i)!=0) continue;
			int energy = getEnergy(i, flag);
			findMaxEnergy(cnt+1, sum+energy, flag|1<<i);
		}
		
	}

	private static int getEnergy(int cnt, int flag) {
		int left = 0;
		int right = 0;
		
		for(int i=cnt-1; i>=0; i--) {
			if((flag&1<<i)!=0) {
				continue;
			}
			else {
				left = energyList[i];
				break;
			}
		}
		for(int i=cnt+1; i<N; i++) {
			if((flag&1<<i)!=0) {
				continue;
			}
			else {
				right = energyList[i];
				break;
			}
		}
		return left * right;
	}

}
