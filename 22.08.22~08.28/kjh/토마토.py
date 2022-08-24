from collections import deque

# 입력값
m, n = map(int, input().split())
box = [list(map(int, input().split())) for _ in range(n)]

# 초기값
q = deque()
# 한바퀴 돌면서 익은 토마토 위치 확인
for i in range(n):
    for j in range(m):
        if box[i][j] == 1:
            q.append((i, j, 0))
# [반례] : 익은 토마토가 하나도 없는 경우
if not q:
    print(-1)
    exit()
# 사방 탐색값
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
# 최종 결과값
ans = 0

# 풀이
while True:
    cr, cc, day = q.popleft()
    # 하루 증가
    day += 1
    for d in range(4):
        nr = cr + dr[d]
        nc = cc + dc[d]
        # 유효 범위 체크
        if nr >= n or nr < 0 or nc >= m or nc < 0: continue
        # 방문, 빈칸 체크
        if box[nr][nc] == 1 or box[nr][nc] == -1: continue
        # 유효하면 익히고
        box[nr][nc] = 1
        # 큐에 추가
        q.append((nr, nc, day))

    # 중단 조건 : q가 비었으면 day 저장하고 break
    if not q:
        ans = day
        break
# 불가능한 경우 체크
for i in range(n):
    for j in range(m):
        if box[i][j] == 0:
            print(-1)
            exit()
print(ans - 1)