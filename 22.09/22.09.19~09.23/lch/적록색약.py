from collections import deque

N = int(input())
base = [list(input()) for _ in range(N)]
visit = [[0 for _ in range(N)]for _ in range(N)]
q = deque()
dr = [-1, 1, 0, 0]
dc = [0, 0, 1, -1]
color = 0
ans = 0
ans2 = 0

for i in range(N):
    for j in range(N):
        if visit[i][j] == 1:continue
        visit[i][j] = 1
        color = base[i][j]
        q.append((i, j))

        while q:
            r, c = q.popleft()
            for k in range(4):
                nr, nc = r+dr[k], c+dc[k]
                if nr < 0 or nr >= N or nc < 0 or nc >= N: continue
                if visit[nr][nc] == 1: continue
                if color == base[nr][nc]:
                    q.append((nr,nc))
                    visit[nr][nc] = 1
        ans += 1

visit = [[0 for _ in range(N)] for _ in range(N)]

for i in range(N):
    for j in range(N):
        if visit[i][j] == 1:continue
        visit[i][j] = 1
        color = base[i][j]
        q.append((i, j))

        while q:
            r, c = q.popleft()
            for k in range(4):
                nr, nc = r+dr[k], c+dc[k]
                if nr < 0 or nr >= N or nc < 0 or nc >= N: continue
                if visit[nr][nc] == 1: continue
                if color == 'B':
                    if base[nr][nc] == 'B':
                        q.append((nr,nc))
                        visit[nr][nc] = 1
                else:
                    if base[nr][nc] != 'B':
                        q.append((nr,nc))
                        visit[nr][nc] = 1
        ans2 += 1
print(ans, ans2)