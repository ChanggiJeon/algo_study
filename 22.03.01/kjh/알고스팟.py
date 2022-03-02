from collections import deque
import sys

# 상하좌우
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

m, n = map(int, input().split())
arr = [list(map(int, sys.stdin.readline().rstrip())) for _ in range(n)]
v = list([0]*m for _ in range(n))
q = deque()
# q에 넣을 값은 현재 좌표 cr, cc와 부순 벽의 누적개수
q.append((0, 0, 0))

while True:
    cr, cc, cnt = q.popleft()
    # 종료 조건 : 마지막에 도착하면
    if cr == n-1 and cc == m-1:
        print(cnt)
        break
    # 탐색
    for i in range(4):
        nr = cr + dr[i]
        nc = cc + dc[i]
        # 가지치기1 : 범위 제한
        if nr < 0 or nr >= n or nc < 0 or nc >= m: continue
        # 가지치기2 : 방문 점검
        if v[nr][nc] == 1: continue
        # 방문 위치가 빈방이면 방문처리 후 cnt 변화없이 우선 탐색(최소값임으로)
        if arr[nr][nc] == 0:
            v[nr][nc] = 1
            q.appendleft((nr, nc, cnt))
        # 방문 위치가 벽이면 방문처리 후 cnt +1하고 나중에 탐색
        elif arr[nr][nc] == 1:
            v[nr][nc] = 1
            q.append((nr, nc, cnt+1))