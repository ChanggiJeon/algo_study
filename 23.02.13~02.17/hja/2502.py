n, m = map(int, input().split())

dp = [0 for _ in range(n)]

dp[0] = 1
dp[1] = 1

while dp[n-1] != m:
    for i in range(2, n):
        dp[i] = dp[i-1] + dp[i-2]
    if dp[i-1] > m:
        dp[0] += 1
        dp[1] = dp[0]
    else:
        dp[1] += 1

print(dp[0])
print(dp[1]-1)
