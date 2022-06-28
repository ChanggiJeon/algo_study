# 문제 잘읽어야 함 안읽으면 엄청 헤맴

N = int(input())
w = [list(input()) for _ in range(N)]
ans = 0
# 하,우
dx = [0, 1]
dy = [1, 0]


def many(y, x, i, m, cnt):
    if cnt == N:
        return
    nx = x + dx[i]
    ny = y + dy[i]
    if nx < N and ny < N and m[y][x] == m[ny][nx]:
        cnt = many(ny, nx, i, m, cnt + 1)
    return cnt


def dps(arr):
    global ans
    cnt = 0
    for y in range(N):
        for x in range(N):

            d = [0, 0]
            if (N - y + 1) > ans and y + 1 < N and arr[y][x] == arr[y + 1][x]:
                d[0] = many(y + 1, x, 0, arr, cnt + 1)
            if (N - x + 1) > ans and x + 1 < N and arr[y][x] == arr[y][x + 1]:
                d[1] = many(y, x + 1, 1, arr, cnt + 1)
            candy = max(d[0] + 1, d[1] + 1)
            if ans < candy:
                ans = candy
                if candy == N:
                    break


for y in range(N):
    for x in range(N):
        for i in range(2):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < N and ny < N and w[y][x] != w[ny][nx]:
                w[y][x], w[ny][nx] = w[ny][nx], w[y][x]
                dps(w)
                w[y][x], w[ny][nx] = w[ny][nx], w[y][x]

print(ans)