N = int(input())
A = [[0] * 10 for i in range(N+1)]
for i in range(10):
    A[1][i] = 1

for i in range(2,N+1):
    for j in range(10):
        for k in range(j,10):
            A[i][j] += A[i-1][k]
print(sum(A[N])%10007)
