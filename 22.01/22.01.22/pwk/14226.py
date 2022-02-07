from collections import deque
S = int(input())
# 시간단축을 위해 각 위치를 다시 안가도록 설정
# 같은 pos라도 클립보드의 크기에 따라 다음 수에 대해 더 빠른 접근 가능 : 이부분 종현님꺼 참고했습니다.
#pos = [0]*2000
pos = [[False]*2000 for _ in range(2000)]
# 각 요소 = (현재 이모티콘 수, 클립보드의 이모티콘 수, cnt)
queue = deque()
queue.append((1,0,0))
while queue:
    num, board, cnt = queue.popleft()
    if num == S:
        print(cnt)
        break
    cnt += 1
    if board != num and not pos[num][num]:
        queue.append((num, num, cnt))
        pos[num][num] = True
    if num+board < 2000 and not pos[num+board][board]:
        queue.append((num+board, board, cnt))
        pos[num+board][board] = True
    if 0 < num-1 and not pos[num-1][board]:
        queue.append((num-1, board, cnt))
        pos[num-1][board] = True