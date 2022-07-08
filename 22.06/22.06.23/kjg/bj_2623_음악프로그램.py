from collections import deque

N, M = map(int, input().split())
graph = [[]  for _ in range(N + 1)]
indegree = [0  for _ in range(N + 1)]

for i in range(M):
    a = list(map(int,input().split()))
    for j in range(1,a[0]):
        graph[a[j]].append(a[j + 1])
        indegree[a[j + 1]] += 1

q = deque()

for i in range(1, N + 1):
    if indegree[i] == 0:
        q.append(i)
ans = []

while q:
    idx = q.popleft()
    ans.append(idx)
    for i in graph[idx]:
        indegree[i] -= 1
        if indegree[i] == 0:
            q.append(i)
        elif indegree[i] < 0:
            break

if len(ans) == N:
    for n in ans:
        print(n)
else:
    print(0)

