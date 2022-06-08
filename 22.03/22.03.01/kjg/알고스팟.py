# 음 데이터 정리 방법에 문제가 있는지 시간초과가 많이나온다
from collections import deque
X,Y = map(int, input().split())
Map = [list(input()) for _ in range(Y)]
visit = [[-1]*X for _ in range(Y)]
# 우하좌상
dx = [1,0,-1,0]
dy = [0,1,0,-1]
point=deque()
point.append((0,0,0))
visit[0][0] = 0
while point:
    x,y,z = point.popleft()
    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]
        if 0<= nx < X and 0<= ny < Y:
            if visit[ny][nx] ==-1:
                if Map[ny][nx] == '1':
                    point.append((nx,ny,z))
                    visit[ny][nx] = visit[y][x]+1
                elif Map[ny][nx] == '0':
                    point.appendleft((nx,ny,z))
                    visit[ny][nx] = visit[y][x]
print(visit[Y-1][X-1])
