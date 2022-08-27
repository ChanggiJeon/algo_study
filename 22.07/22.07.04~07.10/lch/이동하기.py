N, M = map(int, input().split())
base = [list(map(int, input().split())) for _ in range(N)]
num = [[0 for _ in range(M)] for _ in range(N)]
num[0][0] = base[0][0]
for i in range(1, N):
    num[i][0] = num[i-1][0] + base[i][0]
for j in range(1, M):
    num[0][j] = num[0][j-1] + base[0][j]
for i in range(1, N):
    for j in range(1, M):
        num[i][j] = max(num[i-1][j], num[i][j-1]) + base[i][j]
print(num[N-1][M-1])