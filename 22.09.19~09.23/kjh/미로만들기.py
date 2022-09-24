from heapq import heappush, heappop
import sys

# 상하좌우
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

# 입력값
n = int(sys.stdin.readline())
_map = [sys.stdin.readline() for _ in range(n)]

# 초기값
q = list()
heappush(q, (0, 0, 0)) # (cnt, r, c)
visit = [[0] * n for _ in range(n)]
visit[0][0] = 1

# 풀이
while q:
    cnt, cr, cc = heappop(q)

    # 종료 조건 : 끝점 도착 시
    if cr == n-1 and cc == n-1:
        print(cnt)
        break

    for d in range(4):
        nr, nc = cr + dr[d], cc + dc[d]
        # nr, nc가 범위안에 있고 방문 안했으면
        if 0 <= nr < n and 0 <= nc < n and not visit[nr][nc]:
            # 방문 처리
            visit[nr][nc] = 1
            # 1(흰방)이면 그냥 이동
            if _map[nr][nc] == "1":
                heappush(q, (cnt, nr, nc))
            # 0(검은방)이면 바꾸고 이동
            else:
                heappush(q, (cnt + 1, nr, nc))