# 시간초과에서 막히는 문제엿어요.
# list를 deque로 바꿔도 시간초과 나서 sys.stdin.readline()으로 수정
import sys
from collections import deque

N = int(input())
queue = deque()
for _ in range(N):
    order = sys.stdin.readline()[:-1]
    if order == 'pop':
        if not queue:
            print(-1)
        else:
            print(queue.popleft())
    elif order == 'size':
        print(len(queue))
    elif order == 'empty':
        if queue:
            print(0)
        else:
            print(1)
    elif order == 'front':
        if not queue:
            print(-1)
        else:
            print(queue[0])
    elif order == 'back':
        if not queue:
            print(-1)
        else:
            print(queue[-1])
    else:
        queue.append(int(order[5:]))