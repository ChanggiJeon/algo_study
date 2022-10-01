import sys

# 입력값
n = int(sys.stdin.readline())
m = int(sys.stdin.readline())

# 초기값
INF = int(1e9)
graph = [[INF] * n for _ in range(n)]
for _ in range(m):
    _a, _b, c = map(int, sys.stdin.readline().split())
    a, b = _a - 1, _b - 1
    # 중복 경로 존재
    graph[a][b] = min(graph[a][b], c)
# 풀이 : 플로이드 워샬
for k in range(n):
    for i in range(n):
        for j in range(n):
            if i == j: continue
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

# 출력
for i in range(n):
    for j in range(n):
        if graph[i][j] == INF:
            print(0, end=" ")
        else:
            print(graph[i][j], end=" ")
        if j == n-1:
            print()