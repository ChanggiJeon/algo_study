N, K = map(int, input().split())
# 1개의 수를 선택해 idx를 만들수 있는 경우의 수
result = [1] * (N+1)

# 이미 한번은 선택했으니까 k-1회 수행
for _ in range(K-1):
    before = result.copy()
    for i in range(N+1):
        result[i] = sum(before[:i+1])

print(result[-1] % 1000000000)