# python3 시간초과(BFS로 풀면 가능하다고...)
import sys

# 입력값
n, m = map(int, sys.stdin.readline().split())
graph = [[0] * n for _ in range(n)]

# 입력값 처리
for i in range(m):
    _a, _b = map(int, sys.stdin.readline().split())
    # 인덱스 처리
    a, b = _a-1, _b-1
    graph[a][b] = 1

# 풀이 : 플로이드 워샬
for k in range(n):
    for i in range(n):
        for j in range(n):
            # 이미 갈 수 있으면 패스
            if graph[i][j] == 1: continue
            # k를 경우해서 갈 수 있으면 체크
            if graph[i][k] and graph[k][j]:
                graph[i][j] = 1

# 모든 노드에 대해서 나보다 작거나 큰 사실을 모두 알 수 있으면 ans += 1
ans = 0
for i in range(n):
    tmp = 0
    for j in range(n):
        # 자기 자신 패스
        if i == j: continue
        if graph[i][j] or graph[j][i]:
            tmp += 1
    if tmp == n - 1:
        ans += 1
print(ans)