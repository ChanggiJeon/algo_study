n = int(input())
world = [list(map(int, input().split())) for _ in range(n)]
blue = 0
white = 0
def dfs(start_x, end_x, start_y, end_y, n):
    global blue, white
    if n == 0:
        return
    check = world[start_y][start_x]
    change = False
    for i in range(start_y, end_y):
        for j in range(start_x, end_x):
            if world[i][j] != check:
                change = True
                break
        if world[i][j] != check:
            break
    else:
        if check == 0:
            white += 1
        else:
            blue += 1

    if change:
        n = n // 2
        for i in range(start_y, end_y, n):
            for j in range(start_x, end_x, n):
                dfs(j, j + n, i, i + n, n)

dfs(0, n, 0, n, n)
print(white)
print(blue)