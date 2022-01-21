# 상하좌우
dx = [0,0,-1,1]
dy = [-1,1,0,0]

N, M = map(int, input().split())
board = list(input() for _ in range(N))
arr = list([0] * M for _ in range(N))
ans = []
# 십자가가 가능한 범위에서
for i in range(1, N - 1):
    for j in range(1, M - 1):
        # 별을 찾았는데
        if board[i][j] == '*':
            # 십자가 하나가 만들어지면
            cnt = 0
            for k in range(4):
                ni = i + dy[k]
                nj = j + dx[k]
                if board[ni][nj] == '*':
                    cnt += 1
            if cnt == 4:
                # 체크리스트 체크하고
                arr[i][j] = 1
                # 상하좌우 돌면서 가능한 사이즈 찾기
                tmp = 999
                for k in range(4):
                    ci = i
                    cj = j
                    size = 0
                    while True:
                        # 범위를 넘어서거나
                        if ci == -1 or ci == N or cj == -1 or cj == M: break
                        # .을 만나면 탐색 중지
                        if board[ci][cj] == '.': break
                        size += 1
                        ci += dy[k]
                        cj += dx[k]
                    if size < tmp:
                        tmp = size
                for k in range(1, tmp):
                    # 사이즈만큼 가능한 답을 넣어주고
                    ans.append([i+1, j+1, k])
                    # 체크리스트 돌면서 사이즈만큼 체크하기
                    for l in range(4):
                        ni = i + (dy[l] * k)
                        nj = j + (dx[l] * k)
                        arr[ni][nj] = 1
check_sum = 0
check_star = 0
for i in range(N):
    check_sum += sum(arr[i])
    for j in range(M):
        if board[i][j] == '*':
            check_star += 1

if check_sum != check_star:
    print('-1')
else:
    L = len(ans)
    print(L)
    for i in range(L):
        for j in range(3):
            if j == 2:
                print(ans[i][j])
            else:
                print(ans[i][j], end=" ")