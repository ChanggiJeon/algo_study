n, m = map(int,input().split())

days = []
pages = []
for i in range(m):
    d, p = map(int,input().split())
    days.append(d)
    pages.append(p)
    
dp = [0] * (n + 1)
dp_visit = [[]] * (n+1)
for i in range(1, n + 1):
    for j in range(m):
        if i - days[j] >= 0 and j not in dp_visit[i - days[j]]:
            
            if dp[i] < dp[i - days[j]] + pages[j]:
                dp_visit[i] = dp_visit[i - days[j]][:] + [j]
                dp[i] = dp[i - days[j]] + pages[j]
print(max(dp))

