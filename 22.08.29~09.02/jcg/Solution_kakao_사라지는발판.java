import java.io.IOException;
import java.util.ArrayList;

public class Solution_kakao_사라지는발판 {
	/**
	 * 코드가 너무 지저분하지만 리펙토링을 어떻게 해야할지 모르겠음..
	 * Minimax(최소극대화) 알고리즘
	 * 유리함의 정도(?)를 리턴하여 자신의 턴에서는 자신의 유리함이 최대가 되는 선택
	 * 상대방 턴에서는 자신의 유리함이 최소가 되는 선택(AI의 최선)을 고름
	 * 이 문제에서는 먼저 두는 A가 무조건 한번이라도 이기면 최선을 두게 됨으로써 무조건 이기게 됨.
	 * 따라서 결과(A가 이기는지)와 turn수를 반납함.
	 * 반납된 결과가 A가 이기는 경우가 하나도 없을 시에는 A는 turn이 최대가 되는 선택을,
	 * 하나라도 이기는 경우가 있다면 최소가 되는 선택을 하게 된다.
	 * 반대로 B는 A가 이기는 경우가 하나로도 있으면 턴을 최대로 늘리는게 최선의 선택임(A가 무조건 먼저 시작하기 때문에)
	 * 
	 */
	
	static class Result {
		boolean isAWin;
		int turn;
		public Result(boolean isAWin, int turn) {
			super();
			this.isAWin = isAWin;
			this.turn = turn;
		}
	}
	
	static int[] mr = {0,0,1,-1};
	static int[] mc = {1,-1,0,0};
	static int R, C;

	public static void main(String[] args) throws IOException {
		int[][] a = {{1,1,1},{1,0,1},{1,1,1}};
		int[] b = {1, 0};
		int[] c = {1, 2};
		
		System.out.println(solution(a,b,c));
	}
	
	public static int solution(int[][] board, int[] aloc, int[] bloc) {
		R = board.length;
		C = board[0].length;
		Result result = dfs(board,aloc,bloc,0);
		int answer = result.turn;
        return answer;
        
    }

	private static Result dfs(int[][] board, int[] aloc, int[] bloc, int turn) {
		ArrayList<Result> arr = new ArrayList<Solution_kakao_사라지는발판.Result>();
		boolean isWin = false;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		if(turn %2 == 0) {
			int r = aloc[0];
			int c = aloc[1];
			//지금 있는 장소가 없어졌으면 패배
			if(board[r][c] == 0) {
				return new Result(false, turn);
			}
			boolean ableToMove = false;
			
			for(int d=0; d<4; d++) {
				int nr = r + mr[d];
				int nc = c + mc[d];
				//경계를 나갔거나, 0이 아니면 이동가능
				if(boundary(nr,nc) && board[nr][nc]!=0) {
					ableToMove = true;
					board[r][c] = 0;
					Result res = dfs(board, new int[] {nr,nc}, bloc, turn+1);
					arr.add(res);
					board[r][c] = 1;
				}
			}
			//이동할 곳이 없어도 패배
			if(!ableToMove) {
				return new Result(false, turn);
			}
			for(int i=0; i<arr.size(); i++) {
				Result o = arr.get(i);
				if(o.isAWin && min > o.turn) {
					min = o.turn;
					isWin = true;
				}else if(!o.isAWin && max < o.turn){
					max = o.turn;
				}
			}
			if(isWin) {
				return new Result(true, min);
			}else {
				return new Result(false, max);
			}
		}else {
			int r = bloc[0];
			int c = bloc[1];
			if(board[r][c] == 0) {
				return new Result(true, turn);
			}
			boolean ableToMove = false;
			
			for(int d=0; d<4; d++) {
				int nr = r + mr[d];
				int nc = c + mc[d];
				if(boundary(nr,nc) && board[nr][nc]!=0) {
					if(board[nr][nc] == 1) {
						ableToMove = true;
						board[r][c] = 0;
						Result res = dfs(board, aloc, new int[] {nr,nc}, turn+1);
						arr.add(res);
						board[r][c] = 1;
					}
				}
			}
			if(!ableToMove) {
				return new Result(true, turn);
			}
			for(int i=0; i<arr.size(); i++) {
				Result o = arr.get(i);
				if(!o.isAWin && min > o.turn) {
					min = o.turn;
					isWin = true;
				}else if(o.isAWin && max < o.turn){
					max = o.turn;
				}
			}
			if(isWin) {
				return new Result(false, min);
			}else {
				return new Result(true, max);
			}
		}
	}

	private static boolean boundary(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<R && nc<C;
	}
}
