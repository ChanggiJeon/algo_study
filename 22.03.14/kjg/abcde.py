def dfs(idx,number):
    if number == 4:
        print(1)
        exit()
    for i in cha[idx]:
        if  not visit[i]:
            visit[i] = 1
            dfs(i,number+1)
            visit[i] = 0


N,M = map(int,input().split())
cha = [[] for i in range(N)]
visit = [0]*N
for i in range(M):
    x,y = map(int,input().split())
    cha[x].append(y)
    cha[y].append(x)
for j in range(N):
    visit[j] = 1
    dfs(j,0)
    visit[j] = 0
print(0)
    