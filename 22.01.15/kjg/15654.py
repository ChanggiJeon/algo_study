N,M = map(int,input().split())
N_list = sorted(map(int,input().split()))
visit = [0] * N
ans = []

def con(cnt):
    if cnt == M:
        print(*ans)
        return
    for i in range(N):
        if not visit[i]:
            visit[i] = True
            ans.append(N_list[i])
            con(cnt+1)
            visit[i] = False
            ans.pop()
con(0)
    