import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main_BJ_17144_미세먼지안녕 {
    static int R, C, T, up, down;
    static int[][] map;
    //우, 상, 좌, 하 // 우, 하, 좌, 상
    static int[] mr = {0,-1,0,1};
    static int[] mc = {1,0,-1,0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        
        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1) {
                	if(up == 0) {
                		up = i;
                	}else {
                		down = i;
                	}
                }
            }
        }
        
        for(int t=0; t<T; t++) {
            //1. 미세먼지 확산
            map = spread();
            
            int before = 0;
            int next;
            int r=up;
            int c=1;
            int dir = 0;
            //2. 공기 청정기 작동
            for(int i=0; i<(2*C)+(2*(up+1))-5; i++) {
                int nr = r + mr[dir];
                int nc = c + mc[dir];
                if(boundary(nr,nc)) {
                	next = map[r][c];
                	map[r][c] = before;
                	before = next;
                	r = nr;
                	c = nc;
                }else {
                    dir++;
                    i--;
                }
            }
            before = 0;
            next = 0;
            r=down;
            c=1;
            dir = 0;
            for(int i=0; i<(2*C)+(2*(R-down))-5; i++) {
                int nr = r + mr[dir]*-1;
                int nc = c + mc[dir];
                if(boundary(nr,nc)) {
                	next = map[r][c];
                	map[r][c] = before;
                	before = next;
                	r = nr;
                	c = nc;
                }else {
                    dir++;
                    i--;
                }
            }
        }
        int ans = 0;
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j]!=-1) {
                    ans += map[i][j];
                }
            }
        }
        System.out.println(ans);
    }
    private static int[][] spread() {
        int[][] copy = new int[R][C];
 
        for(int r=0; r<R; r++) {
            for(int c=0; c<C; c++) {
                if(map[r][c] > 0) {
                    int cnt = 0;
                    int dustAmount = map[r][c]/5;
                    for(int d=0; d<4; d++) {
                        int nr = r + mr[d];
                        int nc = c + mc[d];
                        if(boundary(nr,nc) && map[nr][nc] !=-1) {
                            copy[nr][nc] += dustAmount;
                            cnt++;
                        }
                    }
                    copy[r][c] += map[r][c] - dustAmount * cnt;
                }
            }
        }
        copy[up][0] = -1;
        copy[down][0] = -1;
        return copy;
    }
    private static boolean boundary(int r, int c) {
        return r>=0 && r<R && c>=0 && c<C;
    }
}