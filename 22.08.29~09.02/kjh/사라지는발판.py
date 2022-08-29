dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

answer = 0
def solve(board, aloc, bloc, ans):
    # 초기값
    global answer
    acr, acc = aloc
    bcr, bcc = bloc
    n = len(board)
    m = len(board[0])
    print(aloc, bloc, ans)

    # 풀이
    # 플레이어 A 이동
    for d in range(4):
        # 현재 발판이 0이면 return
        if board[acr][acc] == 0:
            return
        # 이동할 위치
        anr = acr + dr[d]
        anc = acc + dc[d]
        # 갈 수 있는 발판이 있으면
        if 0 <= anr < n and 0 <= anc < m and board[anr][anc] == 1:
            # 이동
            board[acr][acc] = 0
            ans += 1
        # 없으면
        if ans > answer:
            answer = ans

        # 플레이어 B 이동
        for dd in range(4):
            # 현재 발판이 0이면 return
            if board[bcr][bcc] == 0:
                return
            bnr = bcr + dr[dd]
            bnc = bcc + dc[dd]
            # 유효 범위 체크
            if bnr >= n or bnr < 0 or bnc >= m or bnc < 0: continue
            # 발판 체크
            if board[bnr][bnc] == 0: continue
            # 유효성 검사 통과 시 이동
            board[bcr][bcc] = 0
            ans += 1
            # ans 최대값 확인
            if ans > answer:
                answer = ans
            # 재귀(다음턴)
            solve(board, [anr, anc], [bnr, bnc], ans)
            # 복구
            board[bcr][bcc] = 1
            ans -= 1
        board[acr][acc] = 1
        ans -= 1
    return


def solution(board, aloc, bloc):
    global answer
    solve(board, aloc, bloc, 0)
    return answer


a = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
b = [1,0]
c = [1,2]
print(solution(a, b, c))
