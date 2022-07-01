from collections import deque

p, n, s = map(int,input().split())
graph = [[0] * (p + 1) for _ in range(p + 1)]
visit = []
visit2 = []
for _ in range(n):
    y, x = map(int, input().split())
    graph[y][x] = 1
    graph[x][y] = 1

def dfs(s, cnt):
    visit.append(s)
    if cnt == p:
        return
    for i in range(1, p + 1):
        # 아래 조건문의 순서차이가 시간초과 유뮤를 결정하게 됨 
        # if i not in visit and graph[s][i] == 1:
        if graph[s][i] == 1 and i not in visit:
            dfs(i, cnt + 1)

def bfs(s):
    q = deque()
    q.append(s)
    visit2.append(s)
    while q:
        s1 = q.popleft()
        for i in range(1, p + 1):
            # 아래 조건문의 순서차이가 시간초과 유뮤를 결정하게 됨 
            # if  i not in visit2 and graph[s1][i] == 1:
            if  graph[s1][i] == 1 and i not in visit2:
                q.append(i)
                visit2.append(i)

dfs(s, 0)
bfs(s)
print(*visit)
print(*visit2)