import sys
input = sys.stdin.readline

n = int(input())

max_ans = 0

visit = [0 for _ in range(n + 1)]
dis = [[] for _ in range(n + 1)]
for i in range(n):
    arr = list(map(int,input().split()))
    for i in range(1, len(arr),2):
        if arr[i] == -1:
            break
        dis[arr[0]].append([arr[i],arr[i + 1]])

def dfs(x,s):
    for i in range(len(dis[x])):
        target = dis[x][i]
        if s[target[0]] == 0:
            s[target[0]] = s[x] + target[1]
            dfs(target[0], s)
# 문제에서 제시되어 있지는 않지만 각 노드들이 끊어져있는 상황이 아니라고 한다면
# 거리가 최대가 되는 지점의 위치는 동일하다
# 따라서 임의의 노드에서 시작하여 거리가 최대가 되는 노드를 탐색한다            
dfs(1,visit)
# 중복계산한 것을 지워주기 위해 시작한 노드의 값을 지워준다
visit[1] = 0

d_max = 0
d_idx = 0
for i in range(1,len(visit)):
    if d_max < visit[i]:
        d_max = visit[i]
        d_idx = i

visit2 = [0 for _ in range(n + 1)]
dfs(d_idx,visit2)
visit2[d_idx] = 0
print(max(visit2))

