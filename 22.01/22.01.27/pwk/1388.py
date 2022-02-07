N, M = map(int, input().split())
shape = [list(input()) for _ in range(N)]
visited = [[False]*M for _ in range(N)]

cnt = 0
for i in range(N):
    for j in range(M):
        if not visited[i][j]:
            cnt += 1
            r,c = i,j
            if shape[i][j] == '-':
                while True:
                    visited[r][c] = True
                    if c+1 < M and shape[r][c] == shape[r][c+1]:
                        c += 1
                    else:
                        break
            else:
                while True:
                    visited[r][c] = True
                    if r+1 < N and shape[r][c] == shape[r+1][c]:
                        r += 1
                    else:
                        break

print(cnt)