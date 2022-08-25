# 3차원 배열로 방문체크하기 : https://hongcoding.tistory.com/18
from collections import deque

# 입력값
n, m = map(int, input().split())
_map = list(input() for _ in range(n))

# 초기값
# BFS를 위한 queue
q = deque()
q.append((0, 0, 1, 1)) # (r, c, 벽돌깨기, 거리)
# 상하좌우 이동값
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
# 방문체크
visit = list([[0] * 2 for _ in range(m)] for _ in range(n))
visit[0][0][0] = 1

while q:
    cr, cc, skill, dist = q.popleft()
    # 중단조건 : (n-1, m-1)에 도착한 경우
    if cr == n-1 and cc == m-1:
        # 거리가 ans보다 작으면 갱신
        print(dist)
        exit()

    # 탐색
    for d in range(4):
        nr = cr + dr[d]
        nc = cc + dc[d]
        # 유효범위 체크
        if nr >= n or nr < 0 or nc >= m or nc < 0: continue
        # 방문 체크
        if visit[nr][nc][skill]: continue

        # 이동 위치가 0이면 이동
        if _map[nr][nc] == '0':
            q.append((nr, nc, skill, dist + 1))
            visit[nr][nc][skill] = 1
        # 이동 위치가 1이면
        else:
            # 뚫을 수 있는 지 확인
            if skill:
                q.append((nr, nc, 0, dist + 1))
                visit[nr][nc][0] = 1

print(-1)