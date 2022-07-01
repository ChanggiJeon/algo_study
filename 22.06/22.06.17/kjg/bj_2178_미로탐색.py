from collections import deque
m, n = map(int, input().split())
world = [list(input()) for _ in range(m)]

# 우,하,상,좌
dx = [1, 0, 0, -1]
dy = [0, 1, -1, 0]

def bfs():

    q = deque()
    q.append([0, 0, 1])
    while q:
        y, x, c = q.popleft()

        if y == m - 1 and x == n - 1:
            break
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 > nx or nx >= n or 0 > ny or ny >= m:
                continue
            if world[ny][nx] == '0':
                continue
            if world[ny][nx] == '1':
                world[ny][nx] = c + 1
                q.append([ny, nx, c + 1])
bfs()
print(world[m - 1][n - 1])

