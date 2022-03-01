# 점화식 찾기
# P[0] = 0
# P[1] = P[1]
# P[2] = P[1] + P[1] or P[0] + P[2]
# P[3] = P[1] + P[2] or P[0] + P[3]
# P[1] + P[1]과 P[2] 중 큰 값이 이미 P[2]에 들어갔음으로
# P[4] = P[2] + P[2] or P[1] + P[3] or P[0] + P[4]
# P[5] = P[2] + P[3] or P[1] + P[4] or P[0] + P[5]
# P[6] = P[3] + P[3] or P[2] + P[4] or P[1] + P[5] or P[0] + P[6]
# P[7] = P[3] + P[4] or P[2] + P[5] or P[1] + P[6] or P[0] + P[7]
# ...
# a = i//2, b = a + i%2 일떄,
# P[i] = max(P[a-0] + P[b+0], P[a-1] + P[b+1], ..., P[a-a] + P[b+a])


N = int(input())
P = [0]
P.extend(list(map(int, input().split())))
# DP = P[:]

for i in range(2, N + 1):
    a = i//2
    b = a + i % 2
    for j in range(a+1):
        if P[i] < P[a-j] + P[b+j]:
            P[i] = P[a-j] + P[b+j]
print(P[N])