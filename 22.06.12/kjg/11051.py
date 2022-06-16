def ehang(n, k):
    visit = [[0] * (k + 1) for _ in range(n + 1)]

    for i in range(n + 1):
        visit[i][0] = 1
    for j in range(k + 1):
        visit[j][j] = 1

    for i in range(1, n + 1):
        for j in range(1, k + 1):
            visit[i][j] = visit[i - 1][j - 1] + visit[i - 1][j]
    print(visit[n][k])
m, n = map(int,input().split())
ehang(m,n)