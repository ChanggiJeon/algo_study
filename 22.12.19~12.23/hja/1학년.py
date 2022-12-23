n = int(input())

data = list(map(int,input().split()))

dp = [[0]*21 for _ in range(n)]

dp[0][data[0]] = 1
cnt = 0
for i in range(1, n):
    for j in range(21):
        if dp[i-1][j] != 0:
            if j + data[i] < 21:
                dp[i][j+data[i]] += dp[i-1][j]
            if 0 <= j - data[i]:
                dp[i][j-data[i]] += dp[i-1][j]

print(dp[n-2][data[-1]])