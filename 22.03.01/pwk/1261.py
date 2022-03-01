from collections import deque

dr = [-1,1,0,0]
dc = [0,0,-1,1]

M, N = map(int, input().split())
arr = [list(input()) for _ in range(N)]
min_result = N+M
# queue = [(0,0,0)]
queue = deque()
queue.append((0,0,0))
visited = [[N+M]*M for _ in range(N)]

while queue:
    # r, c, cnt = queue.pop(0)
    r, c, cnt = queue.popleft()
    # 방문했던 기록보다 cnt가 작은 경우에만 갱신 후 계속
    if visited[r][c] <= cnt:
        continue
    else:
        visited[r][c] = cnt
    # 쓸데없이 벽을 많이 판 경우 탈락
    if cnt >= min_result:
        continue
    # 도착한 경우 pass
    if r == N-1 and c == M-1:
        continue
    for i in range(4):
        nr = r + dr[i]
        nc = c + dc[i]
        if 0<=nr<N and 0<=nc<M:
            if arr[nr][nc] == '0':
                if visited[nr][nc] > cnt:
                    # queue.append((nr,nc,cnt))
                    # 이거 종현님 풀이 보고 배웠습니다! 감사합니다!
                    queue.appendleft((nr,nc,cnt))
            else:
                if visited[nr][nc] - 1 > cnt:
                    queue.append((nr,nc,cnt+1))

print(visited[-1][-1])