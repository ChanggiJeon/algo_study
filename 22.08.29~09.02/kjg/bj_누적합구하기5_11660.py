import sys
input = sys.stdin.readline
n,m = map(int,input().split())
# 문제의 핵심은 2가지
# 누적합을 쌓을 수 있는가
# 그리고 결과값의 계산하는데 필요한 인자인 4가지를 이해하고있는가이다
# 인자 4가지는
# 1.목표값이 나타내는 처음부터 최대좌표까지의 누적합
# 2.y축은 최대 x축은 최소보다 1적은 범위까지의 누적합
# 3.x축은 최대 y축은 최소보다 1적은 범위까지의 누적합
# 4.x축은 최소보다 1적은 범위 y축은 최소보다 1적은 범위까지의 누적합
# 이 네가지를 (1 - 2 - 3 + 4)하면 원하는 범위의 누적합이 나온다



world = [list(map(int,input().split())) for _ in range(n)]
target = [list(map(int,input().split())) for _ in range(m)]
dp = [[0 for _ in range(n + 1)] for _ in range(n + 1)]
for i in range(n):
    for j in range(n):
        dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] -dp[i][j] + world[i][j]
for x1,y1,x2,y2 in target:
    print(dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1])