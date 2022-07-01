dr = [-1, 0, 1, 0, 1, 0, -1, 0]
dc = [0, 1, 0, -1, 0, 1, 0, -1]


def diffusion():
    for r in range(R):
        for c in range(C):
            if MAP[r][c] == -1 or 0:
                continue
            tmp = MAP[r][c] // 5
            for i in range(4):
                nr = r + dr[i]
                nc = c + dc[i]
                if nr >= R or nr < 0 or nc >= C or nc < 0 or MAP[nr][nc] == -1:
                    continue
                add_dust[nr][nc] += tmp
                MAP[r][c] -= tmp
    return


def dust_plus():
    for r in range(R):
        for c in range(C):
            MAP[r][c] += add_dust[r][c]
            add_dust[r][c] = 0
    return


def make_wind():
    # 위아래 출발점 선언
    nr_t, nc_t = top-1, 0
    nr_b, nc_b = bottom+1, 0
    # 첫 점은 삭제
    MAP[nr_t][nc_t] = 0
    MAP[nr_b][nc_b] = 0
    idx_t = 0
    idx_b = 4
    while True:
        tmp_r = nr_t + dr[idx_t]
        tmp_c = nc_t + dc[idx_t]
        if tmp_r > top or tmp_r < 0 or tmp_c >= C or tmp_c < 0:
            idx_t += 1
            continue
        elif MAP[tmp_r][tmp_c] == -1:
            break
        else:
            MAP[nr_t][nc_t], MAP[tmp_r][tmp_c] = MAP[tmp_r][tmp_c], MAP[nr_t][nc_t]
            nr_t, nc_t = tmp_r, tmp_c

    while True:
        tmp_r = nr_b + dr[idx_b]
        tmp_c = nc_b + dc[idx_b]

        if tmp_r < bottom or tmp_r >= R or tmp_c >= C or tmp_c < 0:
            idx_b += 1
            continue
        elif MAP[tmp_r][tmp_c] == -1:
            break
        else:
            MAP[nr_b][nc_b], MAP[tmp_r][tmp_c] = MAP[tmp_r][tmp_c], MAP[nr_b][nc_b]
            nr_b, nc_b = tmp_r, tmp_c


R, C, T = map(int, input().split())
MAP = [list(map(int, input().split())) for _ in range(R)]
second = 0
# 확산 먼지
add_dust = [[0] * C for _ in range(R)]
# 공기청정기 찾기
for row in range(R):
    if MAP[row][0] == -1:
        top = row
        bottom = row + 1
        break
while second < T:
    diffusion()
    dust_plus()
    make_wind()
    second += 1

ans = 0
for r in range(R):
    ans += sum(MAP[r])
print(ans+2)