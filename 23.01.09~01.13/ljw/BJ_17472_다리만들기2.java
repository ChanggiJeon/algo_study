package om9d17;

import java.io.*;
import java.util.*;

public class BJ_17472_다리만들기2 {
	static int R,C;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dyx = new int[][] {{0, 1}, {1,0}, {-1,0}, {0,-1}};
	static int islSerial = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];
		for(int i = 0 ; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i < R; i++) {
			for(int j = 0 ; j < C; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					islSerial++;
					dfs(i,j);
				}
			}
		}// 맵을 다 만들었어..
		System.out.println(prim());
	}
	public static int prim() {
		int[][] adjMatrix = new int[islSerial][islSerial];
		for(int i = 0 ; i < islSerial; i++) {
			adjMatrix[i] = minDist(i+1);
		}
		for(int i = 0 ; i < islSerial; i++) {
			adjMatrix[i][i] = 0;
		}
		int[] minVertex = new int[islSerial];
		boolean[] bool = new boolean[islSerial];
		int answer = 0;
		Arrays.fill(minVertex, 11);
		minVertex[0] = 0;
		for(int i = 0 ; i < islSerial; i++) {
			int min = 11;
			int vertex = -1;
			for(int j = 0; j < islSerial; j++) {//가장 가까운 섬과 그 거리를 구한다
				if(!bool[j] && minVertex[j] < min) {
					min = minVertex[j];
					vertex = j;
				}
			}
			if(vertex == -1) return -1;
			answer += min;
			bool[vertex] = true;
			for(int j = 0; j < islSerial; j++) { //새로운 섬에서의 각거리 최소값을 갱신한다.
				if(!bool[j] && minVertex[j] > adjMatrix[vertex][j]) {
					minVertex[j] = adjMatrix[vertex][j];
				}
			}
		}
		return answer;
	}
	public static int[] minDist(int a) {
		int[] adjVertex = new int[islSerial];
		Arrays.fill(adjVertex, 11);
		for(int i = 0 ; i < R; i++) {
			for(int j = 0 ; j < C; j++) {
				if(map[i][j] == a) {
					for(int d = 0 ; d <4; d++) {
						int cnt = 0;
						int rr = i + dyx[d][0];
						int cc = j + dyx[d][1];
						while(true) {
							cnt++;
							if(rr < 0 || cc < 0 ||rr >= R || cc >= C || map[rr][cc] == a) break;
							if(map[rr][cc] != 0) {
								int b = map[rr][cc];
								
								if(cnt - 1 > 1) {
									adjVertex[b-1] = Math.min(adjVertex[b-1], cnt-1);
								}
								break;
							}
							rr = rr + dyx[d][0];
							cc = cc + dyx[d][1];
						}
					}
				}
			}
		}
		return adjVertex;
	}
	public static void dfs(int r, int c) {
		map[r][c] = islSerial;
		visited[r][c] = true;
		for(int i = 0 ; i <4; i++) {
			int rr = r + dyx[i][0];
			int cc = c + dyx[i][1];
			
			if(rr < 0 || cc < 0 ||rr >= R || cc >= C || visited[rr][cc]) continue;
			
			if(map[rr][cc] == 1) {
				dfs(rr, cc);
			}
		}
	}
}
