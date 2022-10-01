import sys
import heapq

input = sys.stdin.readline

h = heapq
n = int(input())

arr = []
for i in range(n):
    h.heappush(arr,int(input()))
ans = 0
while len(arr) > 1:
    a = h.heappop(arr)
    b = h.heappop(arr)
    cnt = a + b
    ans += cnt
    h.heappush(arr,cnt)
print(ans)

