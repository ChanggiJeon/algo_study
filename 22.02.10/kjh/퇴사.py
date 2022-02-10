# 1. DP 한 칸씩 땡기기
# 2. ans + Pi가 DP[Ti - 1]보다 크면 넣기
# 3. DP[0]과 ans 중 큰값 ans에 넣기
# 4. 마지막 배열에서 DP[0]과 ans 중 큰 값 정답

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
DP = [0] * 5
ans = 0

for i in range(N):
    for j in range(4):
        DP[j] = DP[j + 1]
    DP[4] = 0
    if ans + arr[i][1] > DP[arr[i][0] - 1]:
        DP[arr[i][0] - 1] = ans + arr[i][1]
    ans = max(ans, DP[0])
print(ans)