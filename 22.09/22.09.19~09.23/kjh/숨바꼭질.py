# BFS로 찾고 방문체크
import sys
from collections import deque

# 입력값
n, k = map(int, sys.stdin.readline().split())
# n : 수빈이의 위치
# k : 동생의 위치

# 초기값
q = deque()
q.append((n, 0))
visit = [0] * 100001

# 풀이
while q:
    now_p, now_cnt = q.popleft()
    visit[now_p] = 1

    # 동생을 찾으면 끝
    if now_p == k:
        print(now_cnt)
        exit()

    for p in ([now_p + 1, now_p - 1, now_p * 2]):
        # p가 범위안에 있고 방문하지 않았으면 q에 쌓기
        if p > 100000 or p < 0 or visit[p]: continue
        next_cnt = now_cnt + 1
        q.append((p, next_cnt))