# 무난히 한번 만에 통과
# 그래도 코드 짜는 도중에 방향 설정 잘못해서 고뇌에 빠짐

N = int(input())
w = list(map(int,input().split()))
m = [[0]*N for _ in range(N)]

dx=[-1,1,-2,2,-1,1]
dy=[-2,-2,0,0,2,2]
a=w[:2]
b=w[2:]
m[a[0]][a[1]] = -1
li = [(a[0],a[1],0)]
while li:
    y,x,cnt = li.pop(0)
    if [y,x] == b:
        break
    for i in range(6):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0<=nx<N and 0<=ny<N:
            if m[ny][nx] == 0 or m[ny][nx] > cnt+1:
                m[ny][nx] = cnt+1
                li.append((ny,nx,cnt+1))
# for j in m:
#     print(j)
if m[b[0]][b[1]] == 0:
    print(-1)
else:
    print(m[b[0]][b[1]])

