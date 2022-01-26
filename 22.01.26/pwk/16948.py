'''
오랜만에 되게 편안한 정석문제네요 감사합니다.
전 bfs를 까먹지 않았나봐요.
'''
dr = [-2,-2,0,0,2,2]
dc = [-1,1,-2,2,-1,1]

N = int(input())
r1,c1,r2,c2 = map(int, input().split())

visited = [[False]*N for _ in range(N)]
visited[r1][c1] = True
queue = [(r1,c1,0)]
while queue:
    r,c,cnt = queue.pop(0)
    if r == r2 and c == c2:
        print(cnt)
        exit()
    cnt += 1
    for i in range(6):
        nr = r + dr[i]
        nc = c + dc[i]
        if 0<=nr<N and 0<=nc<N:
            if not visited[nr][nc]:
                visited[nr][nc] = True
                queue.append((nr,nc,cnt))
print(-1)