import sys

n, m = map(int, sys.stdin.readline().split())
graph = list([] for _ in range(n))
v = [0] * n
for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    # 연결관계 입력해주기 (양방향)
    graph[a].append(b)
    graph[b].append(a)


def solve(man, depth):
    # 종료 조건 : 연결이 4회이상 발생
    if depth == 4:
        print(1)
        exit()

    # 재귀 조건 : 현재 노드와 연결된 노드 중 방문하지 않은 노드면
    for k in graph[man]:
        if not v[k]:
            v[k] = 1
            solve(k, depth + 1)
            v[k] = 0


for i in range(n):
    v[i] = 1
    solve(i, 0)
    v[i] = 0
print(0)