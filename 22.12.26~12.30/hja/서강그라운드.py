INF = int(1e9)

n, m, r = map(int,input().split())

items = list(map(int, input().split()))

region = [[INF] * (n + 1) for _ in range(n + 1)]

for _ in range(r):
      a, b, l = map(int, input().split())
      region[a][b] = l
      region[b][a] = l

for i in range(1, n+1):
    for j in range(1, n+1):
        if i == j:
            region[i][j] = 0

# 플로이드 워셜 알고리즘 수행
for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            region[i][j] = min(region[i][j], region[i][k] + region[k][j])

maxResult = 0
for i in range(n):
    result = 0
    for j in range(1, n+1):
        if region[i][j] <= m:
            result += items[j-1]
    if maxResult < result:
        maxResult = result

print(maxResult)