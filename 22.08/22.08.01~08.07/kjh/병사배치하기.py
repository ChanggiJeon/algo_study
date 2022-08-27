# 입력값
n = int(input())
power_arr = list(map(int, input().split()))

# 초기값
# 자기자신(1)로 구성
dp = [1] * n
# 두번째 값부터 계산(첫번째는 자기자신 넣으면 끝)
for i in range(1, n):
    # dp의 최대값 찾아서 갱신하기
    tmp_max = 0
    for j in range(0, i):
        # 앞선 병사 중 나보다 파워가 쎈 병사만 고른다.
        if power_arr[j] > power_arr[i]:
            # 그 병사의 dp값이 tmp_max보다 크면 갱신
            if dp[j] > tmp_max:
                tmp_max = dp[j]
    # 최대값 찾았음으로 내 dp값 갱신
    dp[i] += tmp_max
# dp의 최대값 = 가능한 최대 병사수 / n - max(dp) = 가능한 최소 열외수
print(n - max(dp))