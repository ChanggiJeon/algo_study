from collections import deque

dr = [-2, -2, 0, 0, 2, 2]
dc = [-1, 1, -2, 2, -1, 1]

n = int(input())
sr, sc, er, ec = map(int, input().split())
visited = list([0]*n for _ in range(n))
my_q = deque()
my_q.append((sr, sc, 0))

while True:
    # 큐가 비었으면 실패
    if not my_q:
        print(-1)
        break
    # 첫번째 값 뽑아주고
    cr, cc, cnt = my_q.popleft()
    # 목표에 도착하면 cnt 출력
    if cr == er and cc == ec:
        print(cnt)
        break
    # 각 경우의 수에 대한 유효성 검사 후 이동
    for i in range(6):
        nr, nc = cr + dr[i], cc + dc[i]
        # 범위안에 있고 방문 안했으면
        if 0 <= nr < n and 0 <= nc < n and not visited[nr][nc]:
            # 방문체크
            visited[nr][nc] = 1
            my_q.append((nr, nc, cnt + 1))