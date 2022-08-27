from collections import deque

c,r = map(int,input().split())
garden = [list(map(int,input().split())) for _ in range(r)]

# 상,하,좌,우
dc = [0,0,-1,1]
dr = [-1,1,0,0]

rare = 0
visited = [[0] * c for _ in range(r)]
visited2 = [[0] * c for _ in range(r)]





min_day = 0
q = deque()
for i in range(r):
    for j in range(c):
        if garden[i][j] == 1:
            q.append([i,j,0])

while q:
    cr,cc,day = q.popleft()
    # print(cr,cc,day)
    if min_day < day:
        min_day = day

    for i in range(4):
        nc = cc + dc[i]
        nr = cr + dr[i]

        if nc < 0 or nc >= c or nr < 0 or nr >= r:
            continue
        if garden[nr][nc] == 0 and visited2[nr][nc] == 0:
            visited2[nr][nc] = 1
            garden[nr][nc] = 1
            q.append([nr,nc,day + 1])
for i in range(r):
    for j in range(c):
        if garden[i][j] == 0:
            print(-1)
            exit()
else:
    print(min_day)
     

