import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(n)]

# 상,하,좌,우
dr = [-1,1,0,0]
dc = [0,0,-1,1]

def bfs(r,c):
    q = deque()
    q.append([r,c])
    visit[r][c] = 1
    melt = []
    while q:
        water = 0
        cr,cc = q.popleft()
        for i in range(4):
            nr = cr + dr[i]
            nc = cc + dc[i]
            if nr < 0 or nr >= n or nc < 0 or nc >= m:
                continue
            if arr[nr][nc] == 0:
                water += 1
            if visit[nr][nc] or arr[nr][nc] == 0:
                continue
            visit[nr][nc] = 1
            q.append([nr,nc])
        if water > 0:
            if arr[cr][cc] - water <= 0:
                melt.append([cr,cc,0])
            else:
                melt.append([cr,cc,arr[cr][cc] - water])
    return melt
count = 0
while True:
    cnt = 0
    visit = [[0] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if arr[i][j] != 0 and not visit[i][j]:
                cnt += 1
                if cnt == 2:
                    print(count)
                    exit()
                else:
                    meltli = bfs(i,j)
                    for r,c,h in meltli:
                        arr[r][c] = h
    if cnt == 0:
        print(0)
        break
    count += 1


