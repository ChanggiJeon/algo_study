from collections import deque

s = int(input())
my_deque = deque()

# 초기값 설정 [현재 이모티콘길이, 클립보드에 복사된 길이, 탐색깊이]
my_deque.append((1,0,0))
visited = [[0] * 2000 for _ in range(2000)]

while True:
    current, copied, cnt = my_deque.popleft()
    cnt += 1
    visited[current][copied] = 1

    # 지금 검사하는 이모티콘의 길이가 원하는 이모티콘의 길이인 경우 break
    if current == s:
        ans = cnt - 1
        break

    # 덱에 추가할 값이 방문하지 않았어야 함
    # 1번 case : 현재 길이만큼 카피하고 카운트만 늘리기
    if visited[current][current] == 0:
        my_deque.append((current, current, cnt))
        visited[current][current] = 1
    # 2번 case : 이전 카피된 길이만큼 추가하고 카운트 늘리기
    if current + copied < 2000 and visited[current+copied][copied] == 0:
        my_deque.append((current + copied, copied, cnt))
        visited[current+copied][copied] = 1
    # 3번 case : 이모티콘 길이 -1
    if current - 1 > 0 and visited[current-1][copied] == 0:
        my_deque.append((current-1, copied, cnt))
        visited[current-1][copied] = 1
print(ans)