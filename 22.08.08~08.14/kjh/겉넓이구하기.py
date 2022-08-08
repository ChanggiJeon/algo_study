# 6방향에서 보는 평면의 넓이를 구하면 된다.
# 좌, 우 = 각 row에서 내 앞에 값보다 더 쌓아진 만큼의 누적합
# 앞, 뒤 = 각 column에서 내 앞에 값보다 더 쌓아진 만큼의 누적합
# 상, 하 = n * m

# 입력값
n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

# 앞, 뒤, 좌, 우 계산
_max = 0
side_max = 0
for i in range(n):
    for j in range(m):
        # 좌우 계산1 : row의 첫번째 값은 바로 추가
        if j == 0:
            side_max += arr[i][j]
        # 좌우 계산2 : 두번째 값부터 더 쌓아진 만큼 추가
        elif arr[i][j] > arr[i][j-1]:
            side_max += arr[i][j] - arr[i][j-1]

        # 앞뒤 계산1 : column의 첫번째 값은 바로 추가
        if i == 0:
            _max += arr[i][j]
        # 앞뒤 계산2 : 두번째 값부터 더 쌓아진 만큼 추가
        elif arr[i][j] > arr[i-1][j]:
            _max += arr[i][j] - arr[i-1][j]


# 상하값 더해서 정답 출력
ans = 2 * (side_max + _max + n * m)
print(ans)