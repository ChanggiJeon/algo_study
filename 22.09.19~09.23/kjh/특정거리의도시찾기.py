import sys
from collections import deque

# 입력값
N, M, K, X = map(int, sys.stdin.readline().split())
# N : 도시의 개수(노드)
# M : 도로의 개수(간선)
# K : 거리 정보(최종 체크)
# X : 출발 도시(시작 노드)
graph = [[] for _ in range(N + 1)] # 0으로 빈자리 채우면 메모리 초과
for _ in range(M):
    r, c = map(int, sys.stdin.readline().split())
    graph[r].append(c)

# 초기값
INF = int(1e9)
distance = [INF] * (N + 1)
visit = [1] + [0] * N
q = deque()


def dijkstra(x):
    # 시작노드 거리 = 0
    distance[x] = 0
    # 방문처리
    visit[x] = 1
    # 시작노드와 인접한 노드들 거리 계산
    for i in graph[x]:
        q.append(i)
        distance[i] = 1
    # 다른 노드들 처리(N-1개)
    while q:
        # 최단거리 노드 할당
        now = q.popleft()
        # 방문처리
        visit[now] = 1
        # 인접 노드 거리 갱신
        for i in graph[now]:
            # 갈 수 있으면
            if not visit[i]:
                # q쌓고 거리 계산
                q.append(i)
                dist = distance[now] + 1
                if distance[i] > dist:
                    distance[i] = dist


dijkstra(X)
ans = list()
for i in range(1, N+1):
    if distance[i] == K:
        ans.append(i)
if ans:
    ans.sort()
    for a in ans:
        print(a)
else:
    print(-1)
