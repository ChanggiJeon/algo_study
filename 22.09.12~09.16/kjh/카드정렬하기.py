import sys
from heapq import heappop, heappush, heapify

# 입력값
n = int(sys.stdin.readline())
arr = list(int(sys.stdin.readline()) for _ in range(n))
# 힙큐 변환
heapify(arr)

# 초기값
ans = 0

for i in range(n-1):
    a = heappop(arr)
    b = heappop(arr)
    c = a + b
    ans += c
    heappush(arr, c)
print(ans)