def searchDust():
    newDust = set()
    for i in range(r):
        for j in range(c):
            if world[i][j] >= 5:
                newDust.add((i, j))
    return newDust
def expand(list):

    newWorld = [[0] * c for _ in range(r)]
    for cr,cc in list:
        check = []
        for i in range(4):
            nr = cr + udr[i]
            nc = cc + udc[i]

            if nr < 0 or nr >= r or nc < 0 or nc >= c:
                continue
            if [nr,nc]  in cleaner:
                continue
            check.append([nr,nc])
        point = world[cr][cc] // 5

        for chr,chc in check:
            newWorld[chr][chc] += point
            newWorld[cr][cc] -= point
    for i in range(r):
        for j in range(c):
            world[i][j] += newWorld[i][j]


def upClean(cr,cc,d):
    nr = cr + udr[d]
    nc = cc + udc[d]
    if (nr,nc) == (cleaner[0][0],cleaner[0][1]):
        return

    if 0 <= nr <= cleaner[0][0] and 0 <= nc < c:
        world[cr][cc], world[nr][nc] = world[nr][nc], world[cr][cc]
        upClean(nr, nc, d)
    else:
        upClean(cr, cc, (d - 1) % 4)


def downClean(cr,cc,d):
    nr = cr + ddr[d]
    nc = cc + ddc[d]
    if (nr,nc) == (cleaner[1][0],cleaner[1][1]):
        return
    if  cleaner[1][0] <= nr < r and 0 <= nc < c:
        world[cr][cc], world[nr][nc] = world[nr][nc], world[cr][cc]
        downClean(nr, nc, d)
    else:
        downClean(cr, cc, (d - 1) % 4)



r,c,time = map(int,input().split())
world = [list(map(int,input().split())) for _ in range(r)]
#우,상,좌,하
udr = [0,-1,0,1]
udc = [1,0,-1,0]
#우,하,좌,상
ddr = [0,1,0,-1]
ddc = [1,0,-1,0]

cnt = 0
cleaner = []
dust = set()
for i in range(r):
    for j in range(c):
        cnt += world[i][j]
        if world[i][j] >= 5:
            dust.add((i,j))
        if world[i][j] == -1:
            cleaner.append([i,j])
            world[i][j] = 0
            cnt += 1


for t in range(time):
    if t != 0:
        dust = searchDust()
    expand(dust)
    upClean(cleaner[0][0],cleaner[0][1],3)
    downClean(cleaner[1][0],cleaner[1][1],3)

    cnt -= world[cleaner[0][0]][cleaner[0][1]]
    cnt -= world[cleaner[1][0]][cleaner[1][1]]
    world[cleaner[0][0]][cleaner[0][1]] = 0
    world[cleaner[1][0]][cleaner[1][1]] = 0

print(cnt)

