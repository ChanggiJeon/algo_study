dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

n, m = map(int, input().split())
arr = list(input() for _ in range(n))
v = list([0]*m for _ in range(n))
s = list()
cycle = False

for i in range(n):
    for j in range(m):
        # 이미 방문한 곳은 패스
        if v[i][j]: continue
        color = arr[i][j]
        # (현재 위치 and 이전 위치)
        s.append((i,j,-1,-1))
        while s:
            cr, cc, br, bc = s.pop()
            # 현재 위치가 이미 방문한 지점이면 사이클
            if v[cr][cc]:
                cycle = True
                break
            # 방문 안했으면 체크
            v[cr][cc] = 1
            for d in range(4):
                nr = cr + dr[d]
                nc = cc + dc[d]
                # 범위 벗어나면 패스
                if nr >= n or nr < 0 or nc >= m or nc < 0: continue
                # 색이 다르면 패스
                if arr[nr][nc] != color: continue
                # 이전 위치랑 같으면 패스
                if (nr, nc) == (br, bc): continue
                # 위에서 안걸리면 계속 고
                s.append((nr, nc, cr, cc))
        if cycle: break
    if cycle: break

if cycle:
    print("Yes")
else:
    print("No")