import sys
from collections import deque

# 상하좌우
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

# 입력값
n = int(sys.stdin.readline())
arr = list(sys.stdin.readline() for _ in range(n))

# 일반 사람이 봤을 때의 구역 수
# 초기값
visit = [[0] * n for _ in range(n)]
ans_1 = 0
for r in range(n):
    for c in range(n):
        if visit[r][c]: continue
        visit[r][c] = 1
        color = arr[r][c]
        q = deque()
        q.append((r, c))
        while q:
            cr, cc = q.popleft()
            for d in range(4):
                nr, nc = cr + dr[d], cc + dc[d]
                # 유효성 검사
                if nr < 0 or nr >= n or nc < 0 or nc >= n: continue
                if visit[nr][nc]: continue
                # 같은 색 처리
                if arr[nr][nc] == color:
                    q.append((nr, nc))
                    visit[nr][nc] = 1
        ans_1 += 1

# 적록색약인 경우
# 초기값
visit = [[0] * n for _ in range(n)]
ans_2 = 0
for r in range(n):
    for c in range(n):
        if visit[r][c]: continue
        visit[r][c] = 1
        if arr[r][c] in 'RG':
            color = 'RG'
        else:
            color = 'B'
        q = deque()
        q.append((r, c))
        while q:
            cr, cc = q.popleft()
            for d in range(4):
                nr, nc = cr + dr[d], cc + dc[d]
                # 유효성 검사
                if nr < 0 or nr >= n or nc < 0 or nc >= n: continue
                if visit[nr][nc]: continue
                # 같은 색 처리
                if arr[nr][nc] in color:
                    q.append((nr, nc))
                    visit[nr][nc] = 1
        ans_2 += 1
        
# 출력
print(ans_1, end=" ")
print(ans_2)