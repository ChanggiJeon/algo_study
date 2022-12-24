import sys
sys.setrecursionlimit(100000)

def dfs(x,y):
    global cnt
    if x <= -1 or x >= m or y <= -1 or y >= n:
        return False
    if paper[x][y] == 0:
        cnt += 1
        paper[x][y] = 1
        dfs(x-1, y)
        dfs(x, y-1)
        dfs(x+1, y)
        dfs(x, y+1)
        return True
    return False

m, n, k =map(int, input().split())

paper = [[0]*n for _ in range(m)]
result = 0
listResult = []
for _ in range(k):
    x, y, nx, ny = map(int, input().split())

    for i in range(y, ny):  # 2, 4
        for j in range(x, nx): # 0, 4
            paper[i][j] = 1

for i in range(m):
    for j in range(n):
        cnt = 0
        if dfs(i,j) == True:
            result += 1
            listResult.append(cnt)
listResult.sort()
print(result)
for i in listResult:
    print(i,end=' ')