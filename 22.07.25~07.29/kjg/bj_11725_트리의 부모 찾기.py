import sys
input = sys.stdin.readline
a = int(input())
graph = [[] for _ in range(a + 1)]
visit = [0] * (a + 1)
for i in range(a - 1):
    n, m = map(int,input().split())
    graph[n].append(m)
    graph[m].append(n)

def dfs(i, j):
    visit[i] = j
    for nod in graph[i]:
        if visit[nod] == 0:
            dfs(nod, i)
dfs(1,-1)
for i in range(2, len(visit)):
    print(visit[i])
