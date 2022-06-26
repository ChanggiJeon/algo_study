# 재귀 제한 때문에 아래 두줄은 필수
import sys
sys.setrecursionlimit(100000)
# input을 아래와 같이 바꾸지 않으면 시간초과남
# ㅎㅎ 입력속도때문에 계속 해결이 안되니 뭐라해야하나 이걸
input = sys.stdin.readline

def dfs(v):
    visit[v] = True
    for i in check[v]:
        if not visit[i]:
            dfs(i)

m, n = map(int,input().split())
check = [[] for i in range(m + 1)]
visit = [False] * (m + 1)
cnt = 0


for i in range(n):
    y, x = map(int,input().split())
    check[y].append(x)
    check[x].append(y)

for j in range(1, m + 1):
    if not visit[j]:
        dfs(j)
        cnt += 1

print(cnt)
