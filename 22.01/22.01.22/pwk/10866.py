# 편하게 해주셔서 감사합니다~
import sys
from collections import deque

N = int(input())
queue = deque()
for _ in range(N):
    order = sys.stdin.readline()[:-1]
    if order == 'pop_front':
        if not queue:
            print(-1)
        else:
            print(queue.popleft())
    elif order == 'pop_back':
        if not queue:
            print(-1)
        else:
            print(queue.pop())
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
        if 'front' in order:
            queue.appendleft(order[11:])
        else:
            queue.append(order[10:])