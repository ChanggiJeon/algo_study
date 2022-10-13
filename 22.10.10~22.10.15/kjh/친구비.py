import sys

# 입력값
n, m, k = map(int, sys.stdin.readline().split())
cost = list(map(int, sys.stdin.readline().split()))


def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
        return parent[x]
    return x


# 초기값
parent = [i for i in range(n + 1)]

# 풀이(union)
for _ in range(m):
    _v, _w = map(int, sys.stdin.readline().split())
    v = find(_v)
    w = find(_w)
    # 친구비가 작은 애를 부모로
    if cost[v - 1] > cost[w - 1]:
        parent[v] = w
    else:
        parent[w] = v

# 각 노드의 부모를 루트로 갱신
for i in range(1, n+1):
    parent[i] = find(parent[i])

# 친구비 제출
c = 0
for p in set(parent):
    if p == 0:
        continue
    c += cost[p - 1]
    if k < c:
        print("Oh no")
        exit()
print(c)