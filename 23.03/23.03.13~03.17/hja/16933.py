from collections import deque
import sys
sys.stdin = open("test.txt", "r")

n, m, k = map(int, input().split())
graph = [input().rstrip() for _ in range(n)]
visited = [[k + 1 for _ in range(m)] for _ in range(n)]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]


def bfs():
    q = deque()
    q.append((0, 0, 0))
    day = True  # 낮
    result = 1
    while q:
        for _ in range(len(q)):
            x, y, w = q.popleft()

            if x == n-1 and y == m-1:
                return result

            for i in range(4):
                nx, ny = x + dx[i], y + dy[i]
                if nx < 0 or nx >= n or ny < 0 or ny >= m or visited[nx][ny] <= w:
                    continue
                if graph[nx][ny] == '0':  # 벽이 아닐 때
                    q.append((nx, ny, w))
                    visited[nx][ny] = w
                elif w < k:
                    if not day:
                        q.append((x, y, w))  # 나중에 확인
                    else:
                        q.append((nx, ny, w+1))
                        visited[nx][ny] = w
        day = not day
        result += 1
    return -1


print(bfs())
