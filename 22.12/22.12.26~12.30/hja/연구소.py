# 완전탐색

# 바이러스 퍼뜨리기
def dfsVirus(x,y):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx and nx < n and 0 <= ny and ny < m:
            if wall[nx][ny] == 0:
                wall[nx][ny] = 2
                dfsVirus(nx, ny)

def dfsSafe(cnt):
    global maxResult
    if cnt == 3:
        for i in range(n):
            for j in range(m):
                wall[i][j] = lab[i][j]
        for i in range(n):
            for j in range(m):
                if wall[i][j] == 2:
                    dfsVirus(i,j)
        result = 0
        for i in range(n):
            for j in range(m):
                if wall[i][j] == 0:
                    result += 1
        if maxResult < result:
            maxResult = result
        return
    for i in range(n):
        for j in range(m):
            if lab[i][j] == 0:
                lab[i][j] = 1
                cnt += 1
                dfsSafe(cnt)
                lab[i][j] = 0
                cnt -= 1


dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

n,m = map(int, input().split())
lab = []
wall = [[0]*m for _ in range(n)]
for _ in range(n):
    lab.append(list(map(int, input().split())))

maxResult = 0
dfsSafe(0)
print(maxResult)

