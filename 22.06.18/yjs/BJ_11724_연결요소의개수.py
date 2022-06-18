import sys
from collections import deque


def bfs(start):
    global visited
    qu = deque()
    qu.append(start)
    while qu:
        now = qu.popleft()
        for node in range(1, N+1):
            if MAP[now][node] and visited[node] == 0:
                visited[node] = 1
                qu.append(node)
    return


N, M = map(int, input().split())
MAP = [[0] * (N + 1) for _ in range(N + 1)]
for m in range(M):
    p1, p2 = map(int, sys.stdin.readline().split())
    MAP[p1][p2] = 1
    MAP[p2][p1] = 1
visited = [0] * (N + 1)
answer = 0
for n in range(1, N + 1):
    if visited[n] == 0:
        bfs(n)
        answer += 1
print(answer)
