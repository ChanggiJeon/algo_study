
from collections import deque
import sys
input =sys.stdin.readline
r,c = map(int,input().split())
world = [list(map(int,input().split())) for _ in range(r)]

# 상하좌우
dr = [-1,1,0,0]
dc = [0,0,-1,1]



def bfs():

    q = deque()
    q.append([0,0])
    visit[0][0] = 1

    while q:
        sr,sc = q.popleft()

        for i in range(4):
            nr = sr + dr[i]
            nc = sc + dc[i]

            # if nr < 0 or nr >= r or nc < 0 or nc >= c:
            #     continue
            # if visit[nr][nc] != 0:
            #     continue
            if 0<=nr <r and 0<=nc<c and visit[nr][nc] == 0:
                # 다음 위치가 치즈이면 더하기
                if world[nr][nc] >= 1:
                    world[nr][nc] += 1
                # 외부 공기 이면 방문찍기
                else:
                    visit[nr][nc] = 1
                    q.append([nr,nc])


cnt = 0

while True:
    visit = [[0] * c for _ in range(r)]
    bfs()
    flag = 0
    # print(cnt)
    for cr in range(r):
        for cc in range(c):
            # 외부 공기를 2면이상 맞으면 녹고
            if world[cr][cc] >= 3:
                world[cr][cc] = 0
                flag = 1
            # 1면만 맞으면 녹지않으니 원상태로 복귀
            # 공기와 맞닿지 않은 곳은 고칠필요가 없으니 작성 X
            elif world[cr][cc] == 2:
                world[cr][cc] = 1
    if flag == 1:
        cnt += 1
    else:
        break

print(cnt)






