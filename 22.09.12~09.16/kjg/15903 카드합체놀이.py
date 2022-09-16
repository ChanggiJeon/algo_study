import heapq
import sys

input = sys.stdin.readline
n, m = map(int,input().strip().split())
arr = list(map(int,input().split()))
h = heapq
ans = []
for i in arr:
    h.heappush(ans, i)

for j in range(m):
    a = h.heappop(ans)
    b = h.heappop(ans)
    c = a + b
    h.heappush(ans,c)
    h.heappush(ans,c)
print(sum(ans))
