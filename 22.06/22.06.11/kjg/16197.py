from collections import deque
from copy import deepcopy

n, m = map(int,input().split())
array = [ list(input()) for _ in range(n)]
c1 = ''
c2 = ''
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
Ccnt = 0
for y in range(n):
    for x in range(m):
        if array[y][x] == 'o':
            if c1 == '':
                c1 = [y, x]
            else:
                c2 = [y, x]
point = c1 + c2

q = deque([point+  [0]])
# print(q)
while q:
    y1 ,x1, y2, x2, c = q.popleft()
    # print(y1,x1,y2,x2,c)
    if c >= 10:
        break
    for i in range(4):
        nx1 = x1 + dx[i]
        nx2 = x2 + dx[i]
        ny1 = y1 + dy[i]
        ny2 = y2 + dy[i]

        if 0 <= nx1 < m and 0 <= ny1 < n and 0 <= nx2 < m and 0 <= ny2 < n:
            if array[ny1][nx1] == "#":
                nx1, ny1 = x1, y1 
            if array[ny2][nx2] == "#":
                nx2, ny2 = x2, y2
            q.append([ny1, nx1, ny2, nx2, c + 1]) 
        elif 0 <= nx1 < m and 0 <= ny1 < n:
            print(c + 1)
            exit()
        elif 0 <= nx2 < m and 0 <= ny2 < n:
            print(c + 1)
            exit()
        else:
            continue

print(-1)



    