# 현재 위치에서 갈 수 있는 위치의 dp값에 현재 위치의 dp값을 누적합으로 계산하면 목표 위치에 도달할 수 있는 모든 경우의 수를 계산한다.
n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
dp = [[0] * n for _ in range(n)]
dp[0][0] = 1
# 오른, 아래
dr = [0, 1]
dc = [1, 0]
for i in range(n):
    for j in range(n):
        # 마지막에 도달하면 출력 후 종료
        if i == n - 1 and j == n - 1:
            print(dp[i][j])
            break
        # 하나씩 보면서 현재 위치의 dp값을 이동 가능한 위치의 dp값에 누적(방문가능한 모든 경우의 수)
        for k in range(2):
            nr = i + dr[k] * arr[i][j]
            nc = j + dc[k] * arr[i][j]
            # 범위 체크
            if nr >= n or nc >= n: continue
            # 누적합
            dp[nr][nc] += dp[i][j]