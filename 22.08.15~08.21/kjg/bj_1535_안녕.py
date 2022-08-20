import sys
sys.setrecursionlimit(10**6)

max_dp = 0

def brute(idx,people,cnt,hp,hpoint):
    global max_dp
    if cnt == people:
        if max_dp < hpoint:
            max_dp = hpoint
        return

    for i in range(idx,n):
        if hp + insa[i] < 100:
            brute(i + 1,people,cnt + 1,hp + insa[i],hpoint + happy[i])


n = int(input())
insa = list(map(int,input().split()))
happy = list(map(int,input().split()))
dp = [0] * (n + 1)

for i in range(1,n + 1):
    max_dp = 0
    brute(0,i,0,0,0)
    dp[i] = max_dp
print(max(dp))
    