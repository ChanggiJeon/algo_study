n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
dp = [[0] * m for _ in range(n)]

# 하나씩 돌면서 위,왼,대각선 체크
dr = [-1, 0, -1]
dc = [0, -1, -1]
for i in range(n):
    for j in range(m):
        # 위,왼,대각선 모두 범위에서 벗어나면 빈 리스트가 됨으로 0을 기본값으로 넣어둔다.
        check = [0]
        for k in range(3):
            nr = i + dr[k]
            nc = j + dc[k]
            # 범위를 벗어나면 넘어간다.
            if nr >= n or nc >= m or nr < 0 or nc < 0: continue
            # 범위안에 있으면 check에 추가
            check.append(dp[nr][nc])
        # 최댓값을 찾는 문제임으로 check의 최대값을 현재 위치의 값에 더한 후 dp에 추가
        dp[i][j] = arr[i][j] + max(check)

# 마지막 값 출력
print(dp[n-1][m-1])