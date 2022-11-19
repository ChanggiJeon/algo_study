def solution(board, skill):
    answer = 0

    vir = [[0] * (len(board[0]) + 1) for _ in range(len(board) + 1)]
    for t, x1, y1, x2, y2, de in skill:
        if t == 2:
            vir[x1][y1] += de
            vir[x1][y2 + 1] -= de
            vir[x2 + 1][y1] -= de
            vir[x2 + 1][y2 + 1] += de
        else:
            vir[x1][y1] -= de
            vir[x1][y2 + 1] += de
            vir[x2 + 1][y1] += de
            vir[x2 + 1][y2 + 1] -= de

    for i in range(len(board)):
        for j in range(len(board[0])):
            vir[i][j + 1] += vir[i][j]

    for j in range(len(board[0])):
        for i in range(len(board)):
            vir[i + 1][j] += vir[i][j]

    for i in range(len(board)):
        for j in range(len(board[0])):
            board[i][j] += vir[i][j]
            if board[i][j] > 0:
                answer += 1

    return answer