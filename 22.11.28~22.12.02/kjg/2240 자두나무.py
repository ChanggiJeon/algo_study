import sys


n, m = map(int, input().split())
plums = [0]
for i in range(n):
    plums.append(int(sys.stdin.readline()))

dp = [[0] * (m + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    if plums[i] == 1:
        dp[i][0] = dp[i - 1][0] + 1
    else:
        dp[i][0] = dp[i - 1][0]

    for j in range(1, m + 1):
        if j > i:
            break

        if plums[i] == 1 and j % 2 == 0:
            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1]) + 1

        elif plums[i] == 2 and j % 2 == 1:
            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1]) + 1

        else:
            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1])

print(max(dp[-1]))