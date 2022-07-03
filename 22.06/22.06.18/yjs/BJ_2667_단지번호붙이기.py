from collections import deque

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]


def bfs(sr, sc):
    global visited
    qu = deque()
    cnt = 1
    qu.append([sr, sc])
    visited[sr][sc] = 1
    while qu:
        r_, c_ = qu.popleft()
        for i in range(4):
            nr = r_ + dr[i]
            nc = c_ + dc[i]
            if nr >= N or nr < 0 or nc >= N or nc < 0 or visited[nr][nc] == 1 or MAP[nr][nc] == '0':
                continue
            visited[nr][nc] = 1
            qu.append([nr,nc])
            cnt += 1
    return cnt


N = int(input())
MAP = [list(input()) for _ in range(N)]
cnt_list = []
visited = [[0] * N for _ in range(N)]
for r in range(N):
    for c in range(N):
        if MAP[r][c] == '1' and visited[r][c] == 0:
            ret = bfs(r, c)
            cnt_list.append(ret)
print(len(cnt_list))
cnt_list.sort()
for c in range(len(cnt_list)):
    print(cnt_list[c])