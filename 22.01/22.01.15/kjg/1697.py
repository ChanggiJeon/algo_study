N, M = map(int, input().split())
visit = [0] * 100001
def bfs():
    q = []
    q.append(N)
    while q:
        x = q.pop(0)
        # print(x)
        if x == M:
            print(visit[x])
            break
        for  nx in (x-1,x+1,2*x):
            if 0<=nx<=100000 and not visit[nx]:
                visit[nx] = visit[x]+1
                q.append(nx)

bfs()