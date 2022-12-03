import sys
sys.setrecursionlimit(10**6)
def dfs(x,y): ## 안전 지역 세기
    if x <= -1 or x >=n or y <= -1 or y >=n:
        return False
    if floodingArea[x][y] == 1: ## 값보다 작다면
        floodingArea[x][y] = 0
        dfs(x-1, y)
        dfs(x,y-1)
        dfs(x+1, y)
        dfs(x, y+1)
        return True
    return False

n = int(input())

data = []

for _ in range(n):
    data.append(list(map(int, input().split())))

min_value = min(map(min,data))
max_value = max(map(max,data))

MaxResult = 0
for height in range(min_value, max_value+1):
    result = 0
    floodingArea = [[1] * n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            if data[i][j] <= height:
                floodingArea[i][j] = 0

    for i in range(n):
        for j in range(n):
            if dfs(i, j) == True:
                result += 1
    if MaxResult <= result:
        MaxResult = result

    if MaxResult == 0:
        MaxResult = 1

print(MaxResult)