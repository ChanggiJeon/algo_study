N = int(input())
dp = [1, 3, 7, 17, 41]
for i in range(5, N+1):
    dp.append((dp[i-1]*2)%9901 + (dp[i-2])%9901)
print(dp[N]%9901)