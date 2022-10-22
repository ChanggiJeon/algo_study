# 해당 문제 다음과 같다.
# 1. 해마다 빙산이 녹는다
# 2. 녹는 수치는 빙산 상하좌우가 빙산이 아닌 수만큼 녹는다
# 3. 해가 진행되면서 빙산이 두덩어리가 되는 연수를 구하라


import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(n)]

# 상,하,좌,우
dr = [-1,1,0,0]
dc = [0,0,-1,1]

# 로직은 다음과 같다
# 1. 전체 맵에서 빙산이 구역을 찾는다
# 2. 해당 지점을 기준으로 bfs알고리즘을 통해 연결되어 있는 지점을 모두 탐색하며 빙산이 녹는 수치를 확인한다.
# 3-1 만약 햇수가 지나기 전에 다시 탐색이 진행되게 되면 이미 두 덩어리 임으로 현재 해를 출력한다.
# 3-2 추가적인 탐색 없이 전체 탐색이 종료되면 햇수를 증가시킨다. 이때 녹은 빙산의 수치를 적용한다.
# 4. 만약 전체 맵을 탐색했음에도 두 번이상 탐색이 진행되지 않고 빙산이 다 녹을 경우 0을 출력한다.


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


