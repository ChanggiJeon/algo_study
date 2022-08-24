# 각 1번 인덱스에 각 색깔의 초기값을 넣는다.
# 2번째 집부터 자기자신의 색을 제외한 다른 색에 누적된 DP값 중 작은값에 자기 자신의 비용을 더한다.
# 최종적으로 나온 3개의 값 중 가장 큰 값을 출력한다.

# 입력값
n = int(input())
street = [list(map(int, input().split())) for _ in range(n)]

# 초기값
DP = list([0] * 3 for _ in range(n + 1))
DP[1][0] = street[0][0]
DP[1][1] = street[0][1]
DP[1][2] = street[0][2]

# 풀이
# 두번째 집부터 마지막 집까지 결정
for i in range(1, n):
    # 세 가지 색을 모두 탐색
    for j in range(3):
        # 최소비용에 해당하는 색을 찾아서
        min_cost = min(DP[i][(j+1) % 3], DP[i][(j+2) % 3])
        # 자기자신의 비용을 더해서 넣는다.
        DP[i + 1][j] = min_cost + street[i][j]

print(min(DP[n][0], DP[n][1], DP[n][2]))