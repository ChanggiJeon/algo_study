import sys
input = sys.stdin.readline
n, k = map(int,input().split())
coin = [int(input()) for i in range(n)]
cnt = 0
for i in range(n - 1, -1, -1):
    
    if coin[i] <= k:
        b = k // coin[i]
        k =  k - (b * coin[i])
        cnt += b
    if k == 0:
        break
print(cnt)
