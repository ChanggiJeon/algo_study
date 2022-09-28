import sys

# 입력값
n = int(sys.stdin.readline())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

# 풀이 : 플로이드 워샬
for k in range(n):
    for i in range(n):
        for j in range(n):
            # 이미 갈 수 있으면 패스
            if graph[i][j]: continue
            # 경유해서 갈 수 있으면 체크
            if graph[i][k] and graph[k][j]:
                graph[i][j] = 1

# 출력
for i in range(n):
    print(*graph[i])