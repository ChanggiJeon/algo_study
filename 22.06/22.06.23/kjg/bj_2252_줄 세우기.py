from collections import deque

n, m = map(int,input().split())
graph = [[] for _ in range(n + 1)]
inDegree = [0 for _ in range(n + 1)]
q = deque()
ans = []

for i in range(m):
    a, b = map(int,input().split())
    graph[a].append(b)
    inDegree[b] += 1

for i in range(1, n + 1):
    if inDegree[i] == 0:
        q.append(i)

while q:
    tmp = q.popleft()
    ans.append(tmp)
    for i in graph[tmp]:
        inDegree[i] -= 1
        if inDegree[i] == 0:
            q.append(i)
print(*ans)



