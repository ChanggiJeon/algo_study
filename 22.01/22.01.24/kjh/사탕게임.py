def solve(Bomboni):
    global ans

    for i in range(n):
        # 행검사
        cnt = 1
        for j in range(1, n):
            # 연속이면 cnt증가
            if Bomboni[i][j] == Bomboni[i][j - 1]:
                cnt += 1
            # 다르면 초기화
            else:
                cnt = 1
            if ans < cnt:
                ans = cnt

        # 열검사
        cnt = 1
        for j in range(1, n):
            if Bomboni[j][i] == Bomboni[j - 1][i]:
                cnt += 1
            else:
                cnt = 1
            if ans < cnt:
                ans = cnt


n = int(input())
arr = [list(input()) for _ in range(n)]
ans = 1

for i in range(n):
    for j in range(n):
        # 오른쪽 서로 다르면 교환
        if j < n - 1 and arr[i][j + 1] != arr[i][j]:
            arr[i][j], arr[i][j + 1] = arr[i][j + 1], arr[i][j]
            # 먹을 수 있는 사탕 세기
            solve(arr)
            # 교환 돌려놓기
            arr[i][j], arr[i][j + 1] = arr[i][j + 1], arr[i][j]
        # 아래쪽 서로 다르면 교환
        if i < n - 1 and arr[i + 1][j] != arr[i][j]:
            arr[i][j], arr[i + 1][j] = arr[i + 1][j], arr[i][j]
            # 먹을 수 있는 사탕 세기
            solve(arr)
            # 교환 돌려놓기
            arr[i][j], arr[i + 1][j] = arr[i + 1][j], arr[i][j]

print(ans)