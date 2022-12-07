n, m = map(int, input().split())

graphA = []
graphB = []

for i in range(n):
    graphA.append(list(map(int, input())))

for i in range(n):
    graphB.append(list(map(int, input())))

cnt = 0
for i in range(n - 2):
    for j in range(m - 2):
        if graphA[i][j] != graphB[i][j]:
            for k in range(i, i + 3):
                for l in range(j, j + 3):
                    if graphA[k][l] == 0:
                        graphA[k][l] = 1
                    else:
                        graphA[k][l] = 0
            cnt += 1

sameCnt = 0
for i in range(n):
    for j in range(m):
        if graphA[i][j] == graphB[i][j]:
            sameCnt += 1

if sameCnt == n*m: # sameCnt가 n*m이면 A가 B가 된 것
    print(cnt)
else:
    print(-1)

