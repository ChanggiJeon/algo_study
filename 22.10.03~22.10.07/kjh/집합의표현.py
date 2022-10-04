import sys


def find(x):
    # x가 루트이면 x를 반환
    if x == parent[x]:
        return x
    # x가 루트가 아니면 경로압축최적화 후 리턴
    parent[x] = find(parent[x])
    return parent[x]


def union(a, b):
    a = find(a)
    b = find(b)
    # 랭크가 같으면 그냥 a에 합치고 랭크 증가
    if rank[a] == rank[b]:
        parent[b] = a
        rank[a] += 1
    # 랭크가 작은 거를 큰거에 합친다.
    else:
        parent[min(a, b)] = max(a, b)


def check(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return "YES"
    else:
        return "NO"


n, m = map(int, sys.stdin.readline().split())
parent = list(i for i in range(n + 1))
rank = list([1] * (n + 1))
for i in range(m):
    t, _a, _b = map(int, sys.stdin.readline().split())
    if t == 0:
        union(_a, _b)
    else:
        print(check(_a, _b))