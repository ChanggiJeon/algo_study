a = int(input())
data = [list(map(int, input().split())) for _ in range(a)]
rank = [1] * a

def dfs(x):
    for i in range(a):
        if i == x:
            continue
        if data[x][0] < data[i][0] and data[x][1] < data[i][1]:
            rank[x] += 1
for i in range(a):
    dfs(i)
print(*rank)