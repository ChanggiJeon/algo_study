from collections import deque
# 12시부터 시계방향으로 8방향 체크
dr = [0, 1, 1, 1, 0, -1, -1, -1]
dc = [-1, -1, 0, 1, 1, 1, 0 , -1]
def checkAround(x, y):
    global my_deque
    for k in range(8):
        nr = x + dr[k]
        nc = y + dc[k]
        # index error 처리
        if nr >= h or nr < 0 or nc >= w or nc < 0: continue
        # 땅인데 방문처리 안되있으면 처리
        if arr[nr][nc] == 0: continue
        if visited[nr][nc] == 1: continue
        visited[nr][nc] = 1
        my_deque.append((nr,nc))


while True:
    my_deque = deque()
    w, h = map(int, input().split())
    if w == h == 0:
        break
    arr = [list(map(int, input().split())) for _ in range(h)]
    visited = [[0] * w for _ in range(h)]
    ans = 0

    for i in range(h):
        for j in range(w):
            # 바다면 넘어감
            if arr[i][j] == 0: continue
            # 처음 도착하면 방문처리, 카운트 증가, 주변 방문체크
            if visited[i][j] == 1: continue
            visited[i][j] = 1
            ans += 1
            checkAround(i, j)
            # 연결된 땅 전부 방문 체크
            while my_deque:
                r, c = my_deque.popleft()
                checkAround(r, c)

    print(ans)