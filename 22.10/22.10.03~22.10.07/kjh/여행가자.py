import sys


def find(x):
    # x가 루트이면 x를 반환
    if x == parent[x]:
        return x
    # x가 루트가 아니면 경로압축최적화 후 부모를 리턴
    parent[x] = find(parent[x])
    return parent[x]


def union(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return
    else:
        # 큰거의 부모를 작은거로
        parent[max(a, b)] = min(a, b)


# 입력값
n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
connection = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
plan = list(map(int, sys.stdin.readline().split()))

# 초기값
parent = list(i for i in range(n + 1))

# 풀이
for i in range(n):
    for j in range(n):
        # 연결되어 있으면 합치기
        if connection[i][j]:
            union(i + 1, j + 1)

# 집합의 시작점 체크
root = parent[plan[0]]
for i in set(plan):
    if parent[i] != root:
        print("NO")
        exit()
print("YES")
