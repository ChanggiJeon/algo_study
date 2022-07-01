from collections import deque


def dfs(now):
    global ans_dfs
    for n in range(1, N + 1):
        if MAP[now][n] and visited_dfs[n] == 0:
            ans_dfs.append(str(n))
            visited_dfs[n] = 1
            dfs(n)
    return


def bfs(num):
    global ans_bfs
    qu = deque()
    qu.append(num)
    while qu:
        now = qu.popleft()
        for n in range(1, N + 1):
            if MAP[now][n] and visited_bfs[n] == 0:
                ans_bfs.append(str(n))
                visited_bfs[n] = 1
                qu.append(n)

    return


N, M, V = map(int, input().split())
MAP = [[0] * (N + 1) for _ in range(N + 1)]
for m in range(M):
    dot1, dot2 = map(int, input().split())
    MAP[dot1][dot2] = 1
    MAP[dot2][dot1] = 1
ans_dfs = [str(V)]
ans_bfs = [str(V)]
visited_dfs = [0] * (N + 1)
visited_bfs = [0] * (N + 1)
visited_dfs[V] = 1
visited_bfs[V] = 1
dfs(V)
bfs(V)
print(' '.join(ans_dfs) + '\n' + ' '.join(ans_bfs))
