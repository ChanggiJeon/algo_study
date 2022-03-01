dr = [-2,-2,-1,-1,1,1,2,2]
dc = [-1,1,-2,2,-2,2,-1,1]

T = int(input())
for _ in range(T):
    N = int(input())
    r, c = map(int, input().split())
    gr, gc = map(int, input().split())
    visited = [[False]*N for _ in range(N)]
    visited[r][c] = True
    queue = [(r,c,0)]
    while queue:
        r, c, cnt = queue.pop(0)
        if r == gr and c == gc:
            print(cnt)
            break
        for i in range(8):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0<=nr<N and 0<=nc<N:
                if not visited[nr][nc]:
                    visited[nr][nc] = True
                    queue.append((nr,nc,cnt+1))
