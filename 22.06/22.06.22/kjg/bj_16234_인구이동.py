from collections import deque
import sys
input = sys.stdin.readline
N, L, R = map(int, input().split())
world = [list(map(int,input().split())) for _ in range(N)]

# 상,하, 좌, 우
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

# 와 python3로는 80퍼에서 무조건 시간초과 
# bfs의 문제도 아니었고 dfs의 문제도 아니었음
# 이것 때문에 8번 시간초과 나고 4번 갈아없었어 ㅠㅠ
# def dfs(y, x, n):
#     global cnt, popul
#     visit[y][x] = n
#     unions[n].append([y, x])
#     cnt += 1
#     popul += world[y][x]
#     for k in range(4):
#         nx = x + dx[k]
#         ny = y + dy[k]
#         if 0 > nx or nx >= N or 0 > ny or ny >= N:
#             # print("!")
#             continue
#         if visit[ny][nx] == -1 :
#             cp = abs(world[y][x] - world[ny][nx])
#             if L <= cp <= R:
#                 dfs(ny, nx, n)

def bfs(y,x):
    q = deque()
    q.append([y, x])
    lan = [[y, x]]
    while q:
        y, x = q.popleft()
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if 0 > nx or nx >= N or 0 > ny or ny >= N:
                # print("!")
                continue
            if visit[ny][nx] != 0:
                continue
            cp = abs(world[y][x] - world[ny][nx])
            if L > cp or cp > R:
                continue
            visit[ny][nx] = 1
            lan.append([ny, nx])
            q.append([ny, nx])
    return lan
ans = 0
while True:
    mov = False
    visit = [[0] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if visit[i][j] == 0:
                visit[i][j] = 1
                unions = bfs(i, j)
                if len(unions) > 1:
                    mov = True
                    num = 0
                    for y,x in unions:
                        num += world[y][x]
                    num = num // len(unions)
                    for y,x in unions:
                        world[y][x] = num
    if not mov:
        break
    ans += 1
print(ans)

