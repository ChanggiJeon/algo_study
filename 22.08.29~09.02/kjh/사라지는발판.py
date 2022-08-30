# 참조 : https://tiktaek.tistory.com/88
from copy import deepcopy
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
n, m = 0, 0
INF = 99999999


def check_valid_position(board, cr, cc):
    for d in range(4):
        nr, nc = cr + dr[d], cc + dc[d]
        # 범위 안에 있고 이동할 위치가 1이면 유효
        if 0 <= nr < n and 0 <= nc < m and board[nr][nc]:
            return True
    # 사방이 다 유효하지 않은경우 이동 불가 리턴
    return False


def play(cur_board, A, B, step):
    # 1. 현재턴이 누구턴인지 알아야함. A부터, 0부터 시작임으로 짝수턴 = A / 홀수턴 = B
    if step % 2 == 0:
        x, y = A
        turn = 'A-turn'
    else:
        x, y = B
        turn = 'B-turn'
    # 2. 현재턴의 플레이어가 패배하는지 승리하는지 알아야함
    # 이동 불가능하면 움직이지 않고 그 자리에서 패배
    if not check_valid_position(cur_board, x, y):
        return ('lose', 0)
    # 이동 가능한데 A와 B가 같은 위치면 한 칸 이동 후 승리
    if A == B:
        return ('win', 1)

    # 초기값
    # 재귀했다가 다시 되돌리는 과정을 없애기 위해 deepcopy
    new_board = deepcopy(cur_board)
    # 이동 가능함으로 현재 위치 체크
    new_board[x][y] = 0
    # 초기값이 False일 뿐 지는 플레이어라는 뜻은 아님
    win = False
    # 최대값은 작은값, 최소값은 큰값으로 초기값 설정
    max_step, min_step = 0, INF

    # 사방탐색 후 이동 가능하면 이동 후 다음턴(재귀)
    for d in range(4):
        nr, nc = x + dr[d], y + dc[d]
        if 0 <= nr < n and 0 <= nc < m and new_board[nr][nc]:
            if turn == 'A-turn':
                res = play(new_board, [nr, nc], B, step + 1)
            else:
                res = play(new_board, A, [nr, nc], step + 1)
            # 다음턴의 결과로 상대가 지면 나는 이기는 경우임
            if res[0] == 'lose':
                win = True
                # 이기는 경우 최소값 갱신
                min_step = min(min_step, res[1])
            else:
                # 지는 경우 최대값 갱신
                max_step = max(max_step, res[1])

    # 내가 이기는 경우 최소값 반환
    if win == True:
        return ('win', min_step + 1)
    else:
        return ('lose', max_step + 1)


def solution(board, aloc, bloc):
    global n, m
    n = len(board)
    m = len(board[0])
    answer = play(board, aloc, bloc, 0)
    return answer[1]


a = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
b = [1,0]
c = [1,2]
print(solution(a, b, c))
