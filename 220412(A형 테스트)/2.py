from collections import deque

# 상하좌우
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]


def solve(lev, q, v):
    while True:
        # q가 다 비어버리면 실패
        if not q:
            return 0
        cr, cc = q.popleft()
        # 1. 좌우 살피고 미방문 발판 있으면 deque에 추가
        for d in range(2, 4):
            nr = cr + dr[d]
            nc = cc + dc[d]
            if 0 <= nr < n and 0 <= nc < m and not v[nr][nc] and arr[nr][nc]:
                # 도착점이면 return
                if arr[nr][nc] == 3:
                    return lev
                # 그냥 발판이면 앞쪽에 추가
                v[nr][nc] = 1
                q.appendleft((nr, nc))

        # 2. 상하 난이도 범위 내에서 다 살피고 미방문 발판 있으면 deque에 추가
        for d in range(2):
            for i in range(1, lev + 1):
                nr = cr + dr[d] * i
                nc = cc + dc[d] * i
                if 0 <= nr < n and 0 <= nc < m and not v[nr][nc] and arr[nr][nc]:
                    # 도착점이면 return
                    if arr[nr][nc] == 3:
                        return lev
                    # 그냥 발판이면 뒤쪽에 추가
                    v[nr][nc] = 1
                    q.append((nr, nc))


T = int(input())
for tc in range(1, T+1):
    # n은 높이 m은 너비
    n, m = map(int, input().split())
    arr = list(list(map(int, input().split())) for _ in range(n))

    # 난이도 증가시키면서 검사하기
    ans = 0
    for level in range(1, 50):
        if ans:
            break
        base_q = deque()
        # 시작점 입력(첫발판 모두가 시작점임)
        for i in range(m):
            base_q.append((n - 1, i))
        # 방문 체크용 리스트
        visit = list([0] * m for _ in range(n - 1))
        # 시작점은 다 체크
        visit.append([1] * m)
        # 검사 시작
        ans = solve(level, base_q, visit)
    print(f'#{tc}', ans)