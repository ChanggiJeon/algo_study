n, m = map(int, input().split())
arr = list(input() for _ in range(n))
ans = 0

for i in range(n):
    for j in range(m):
        if arr[i][j] == '-':
            # 첫번째 -는 무조건 카운트
            if j == 0:
                ans += 1
            else:
                # -이면 이전 값이 -일때만 노카운트
                if arr[i][j-1] == '-':
                    continue
                ans += 1
        else:
            # 첫번째 |는 무조건 카운트
            if i == 0:
                ans += 1
            else:
                # |이면 이전 값이 |일때만 노카운트
                if arr[i-1][j] == '|':
                    continue
                ans += 1
print(ans)