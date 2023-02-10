import sys
from collections import deque

input = sys.stdin.readline
s, t = map(int, input().split())
queue = deque()
check = set()
queue.append((s,''))
check.add(s)
MAX = 10e9

if s == t:
    print(0)
else:
    ans = -1
    while queue:
        ss, se = queue.popleft()
        if ss == t:
            ans = se
            print(ans)
            exit(0)

        ns = ss * ss
        if 0 <= ns <= MAX and ns not in check:
            queue.append((ns, se+'*'))
            check.add(ns)

        ns = ss + ss
        if 0 <= ns <= MAX and ns not in check:
            queue.append((ns, se+'+'))
            check.add(ns)

        ns = 1
        if ns not in check:
            queue.append((ns, se+'/'))
            check.add(ns)
    print(ans)