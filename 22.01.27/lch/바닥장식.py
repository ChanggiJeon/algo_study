N, M = map(int, input().split())
base = [0 for _ in range(N)]
cnt = N*M
for i in range(N):
    base[i] = list(input())
for i in range(N):
    for j in range(M):
        if base[i][j] == '-':
            if j == M-1 : continue
            if base[i][j+1] == '-':
                cnt -= 1
        else:
            if i == N-1 : continue
            if base[i+1][j] == '|':
                cnt -= 1
print(cnt)