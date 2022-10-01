# 우선순위 큐 : https://chanhuiseok.github.io/posts/ds-4/
# 파이썬 힙큐 : https://www.daleseo.com/python-heapq/
import sys
from heapq import heappop, heappush, heapify

# 입력값
n, m = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))

# 배열을 힙큐로 만들기
heapify(arr)

# 풀이 : 최소값 두개 뽑고 합 구해서 두번 추가
for i in range(m):
    a = heappop(arr)
    b = heappop(arr)
    c = a + b
    heappush(arr, c)
    heappush(arr, c)
print(sum(arr))