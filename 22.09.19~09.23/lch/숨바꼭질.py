from collections import deque

N, K = map(int, input().split())
q = deque()
q.append((N, 0))
path = [0] * 100001

while q:
    now_p, now_cnt = q.popleft()
    path[now_p] = 1
    if now_p == K:
        print(now_cnt)
        exit()
    for p in ([now_p + 1, now_p - 1, now_p * 2]):
        if p > 100000 or p < 0 or path[p]: continue
        next_cnt = now_cnt + 1
        q.append((p, next_cnt))