N,M,y,x,k = map(int,input().split())
world = [list(map(int, input().split())) for _ in range(N)]
roll_d = list(map(int, input().split()))

# 우,좌, 상,하
dx = [1,-1,0,0]
dy = [0,0,-1,1]

dice = [0,0,0,0,0,0,0]

# 1:동, 2:서, 3:북, 4: 남
def rolling(dr) :
    if dr == 1:
        dice[1], dice[3], dice[4], dice[6] = dice[4], dice[1], dice[6], dice[3]  
    elif dr == 2:
        dice[1], dice[3], dice[4], dice[6] = dice[3], dice[6], dice[1], dice[4] 
    elif dr == 3:
        dice[1], dice[2], dice[5], dice[6] = dice[5], dice[1], dice[6], dice[2] 
    elif dr == 4:
        dice[1], dice[2], dice[5], dice[6] = dice[2], dice[6], dice[1], dice[5] 

for i in roll_d:
    nx = x + dx[i - 1]
    ny = y + dy[i - 1]
    if 0 <= nx < M and 0 <= ny < N:
        rolling(i)
        if world[ny][nx] == 0:
            world[ny][nx] = dice[6]
        else:
            dice[6] = world[ny][nx]
            world[ny][nx] = 0
        x, y = nx, ny
        print(dice[1])