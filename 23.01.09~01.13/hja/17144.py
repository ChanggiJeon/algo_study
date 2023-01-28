def spread(x, y):
    dx = [-1, 0, 1, 0]
    dy = [0, -1, 0, 1]
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or ny < 0 or nx >= r or ny >= c:
            continue
        if nx == -1 or ny == -1:
            continue

    return 0

r, c, t = map(int, input().split())
array = []
for i in range(r):
    array.append(list(map(int,input().split())))
cleaner = []
for i in range(r):
    for j in range(c):
        if array[i][j] == -1:
            cleaner.append((i, j))

for time in range(t):
    for i in range(r):
        for j in range(c):
            if array[i][j] != 0 and array[i][j] == -1:
                spread(i,j)



result = 0
for i in range(r):
    for j in range(c):
        result += array[i][j]
print(array)