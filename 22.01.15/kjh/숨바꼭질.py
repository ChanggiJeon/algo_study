from collections import deque

# 수빈이는 N에 위치 / 동생은 K에 위치
# 수빈이는 1초 후에 X-1 or X+1 or 2*X에 위치
# 수빈이가 K에 도착하는 가장 빠른 시간을 구하시오.
N, K = map(int, input().split())
visited = [0] * 100001
queue = deque()
queue.append([N, 0])
while queue[0][0] != K:
    x = queue[0][0]
    cnt = queue[0][1]
    queue.popleft()
    visited[x] = 1
    if x > 0 and visited[x - 1] == 0:
        queue.append([x - 1, cnt + 1])
    if x < 100000 and visited[x + 1] == 0:
        queue.append([x + 1, cnt + 1])
    if 2 * x < 100001 and visited[2 * x] == 0:
        queue.append([x * 2, cnt + 1])
print(queue[0][1])