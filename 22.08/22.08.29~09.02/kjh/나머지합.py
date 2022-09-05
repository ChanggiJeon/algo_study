# 입력값
n, m = map(int, input().split())
arr = list(map(int, input().split()))

# 초기값
DP = [arr[0]]
for i in range(1, n):
    DP.append(DP[i-1] + arr[i])
rest_list = [0] * m
ans = 0

# 풀이 : 내 이전 값중 나와 같은 나머지를 가진 값의 수만큼 나누어 떨어지는 구간합 존재
for i in range(n):
    rest = DP[i] % m

    # 나머지가 같은 값의 개수만큼 추가
    ans += rest_list[rest]

    # 그냥 나누어 떨어지면 자기자신 체크하고 추가 아니면 그냥 추가
    if rest == 0:
        ans += 1
    rest_list[rest] += 1

print(ans)