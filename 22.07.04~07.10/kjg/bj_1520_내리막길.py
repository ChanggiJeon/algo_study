from collections import deque
N, M = map(int, input().split())
world = [list(map(int, input().split())) for _ in range(N)]

# 상하좌우
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

dp = [[-1] * M for _ in range(N)]
def dfs(y,x):
    
    if [y,x] == [N -1,M - 1]:
        return 1
    
    if dp[y][x] != -1:
        return dp[y][x]

    ways = 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 > nx or nx >= M or 0 > ny or ny >= N:
            continue
        if world[y][x] <= world[ny][nx]:
            continue
        ways += dfs(ny,nx)
    dp[y][x] = ways
    return dp[y][x]
print(dfs(0,0))
for v in dp:
    print(v)

