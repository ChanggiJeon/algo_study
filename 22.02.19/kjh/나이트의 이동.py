from collections import deque

# 시계방향 이동(8방향)
dr = [-2, -1, 1, 2, 2, 1, -1, -2]
dc = [1, 2, 2, 1, -1, -2, -2, -1]

T = int(input())
for tc in range(T):
    n = int(input())
    sr, sc = map(int, input().split())
    er, ec = map(int, input().split())
    if sr == er and sc == ec:
        print(0)
        continue
    visit = list([0]*n for _ in range(n))
    queue = deque()
    queue.append((sr, sc, 0))
    stop = True

    while stop:
        cr, cc, cnt = queue.popleft()

        for i in range(8):
            nr = cr + dr[i]
            nc = cc + dc[i]
            if nr == er and nc == ec:
                print(cnt + 1)
                stop = False
                break
            if nr < 0 or nc < 0 or nr >= n or nc >= n or visit[nr][nc]: continue
            queue.append((nr, nc, cnt + 1))
            visit[nr][nc] = 1


