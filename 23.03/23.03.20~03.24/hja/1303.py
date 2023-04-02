import sys
from collections import deque
sys.stdin = open("test.txt", "r")

n, m = map(int, input().split())
graph = [list(input().strip()) for _ in range(m)]

visited = [[False] * n for _ in range(m)]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]


def bfs(x, y, color):
    q = deque()
    q.append((x, y))
    visited[x][y] = True
    result = 1
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if nx < 0 or nx >= m or ny < 0 or ny >= n or visited[nx][ny] == True:
                continue
            if graph[nx][ny] == color:
                visited[nx][ny] = True
                q.append((nx, ny))
                result += 1
    return result ** 2


result_w, result_b = 0, 0
for i in range(m):
    for j in range(n):
        if graph[i][j] == 'W' and not visited[i][j]:
            result_w += bfs(i, j, 'W')
        elif graph[i][j] == 'B' and not visited[i][j]:
            result_b += bfs(i, j, 'B')

print(result_w, result_b)
