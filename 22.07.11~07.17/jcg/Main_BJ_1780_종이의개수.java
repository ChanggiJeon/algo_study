import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_1780_종이의개수 {
	
	static int N;
	static int[][] table;
	static int ans[] = new int[3];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		table = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		simul(0,0,N);
		sb.append(ans[0]+"\n").append(ans[1]+"\n").append(ans[2]+"\n");
		System.out.print(sb);
	}

	private static void simul(int r, int c, int size) {
		
		int start = table[r][c];
		if(size==1) {
			ans[start+1]++;
			return;
		}
		
		boolean check = true;
		o: for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(table[i][j]!=start) {
					check = false;
					break o;
				}
			}
		}
		
		if(!check) {
			int ns = size/3;
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					simul(r+i*ns,c+j*ns,ns);
				}
			}
		}else {
			ans[start+1]++;
		}
		return;
		
	}

}
