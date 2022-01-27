def dfs(y,x,d):
    global cnt
    visit[y][x] = 1
    nx,ny = x,y
    if d=='-':
        nx = x+1
    elif d=='|':
        ny = y+1
    if 0<=nx<M and 0<=ny<N and not visit[ny][nx] and w[ny][nx] == d:
        dfs(ny,nx,d)
    else:
        cnt +=1

N,M = map(int,input().split())
w = [list(input()) for _ in range(N)]
cnt =0
visit = [[0]*M for _ in range(N)]
for y in range(N):
    for x in range(M):
        if visit[y][x]:
            continue
        dfs(y,x,w[y][x])
print(cnt)