def turn(direction):
    global dice

    if direction == 1:
        dice[1][0], dice[1][1], dice[1][2], dice[3][1] = dice[3][1], dice[1][0], dice[1][1], dice[1][2]
    elif direction == 2:
        dice[1][0], dice[1][1], dice[1][2], dice[3][1] = dice[1][1], dice[1][2], dice[3][1], dice[1][0]
    elif direction == 3:
        dice[0][1], dice[1][1], dice[2][1], dice[3][1] = dice[1][1], dice[2][1], dice[3][1], dice[0][1]
    else:
        dice[0][1], dice[1][1], dice[2][1], dice[3][1] = dice[3][1], dice[0][1], dice[1][1], dice[2][1]


# 입력값
n, m, x, y, k = map(int, input().split())
_map = [list(map(int, input().split())) for _ in range(n)]
_order = list(map(int, input().split()))

# 초기값
dice = list([0] * 3 for _ in range(4))
# 동서북남
dr = [0, 0, -1, 1]
dc = [1, -1, 0, 0]
nx, ny = x, y

# 풀이
for d in _order:
    # 이동 가능한지 확인
    nx += dr[d - 1]
    ny += dc[d - 1]
    # 범위 벗어나면 롤백 후 건너 뛰기
    if nx >= n or nx < 0 or ny >= m or ny < 0:
        nx -= dr[d - 1]
        ny -= dc[d - 1]
        continue
    # 굴리고
    turn(d)
    # 현재 위치의 값이 0이면 다이스 밑면을 지도에 복사
    if _map[nx][ny] == 0:
        _map[nx][ny] = dice[3][1]
    # 현재 위치의 값이 0이 아니면 현재 값을 다이스 밑면에 복사 후 0으로 초기화
    else:
        dice[3][1] = _map[nx][ny]
        _map[nx][ny] = 0
    # 윗면 출력
    print(dice[1][1])
