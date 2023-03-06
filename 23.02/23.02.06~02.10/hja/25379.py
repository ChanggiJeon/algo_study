n = int(input())
List_n = list(map(int, input().split()))
S = [0] * 2
result = [0, 0]
for i in range(1, n+1):
    x = List_n[i-1] % 2  # 0, 1로만 이루어져 있다고 가정
    S[x] += 1
    result[x] += S[1-x]
print(min(result))
