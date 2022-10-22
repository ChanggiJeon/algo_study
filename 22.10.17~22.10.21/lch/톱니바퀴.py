def spin(idx, n):
    if n == 1:
        cog[idx][0], cog[idx][1], cog[idx][2], cog[idx][3], cog[idx][4], cog[idx][5], cog[idx][6], cog[idx][7] = cog[idx][7],cog[idx][0], cog[idx][1], cog[idx][2], cog[idx][3], cog[idx][4], cog[idx][5], cog[idx][6],
    else:
        cog[idx][0], cog[idx][1], cog[idx][2], cog[idx][3], cog[idx][4], cog[idx][5], cog[idx][6], cog[idx][7] = cog[idx][1], cog[idx][2], cog[idx][3], cog[idx][4], cog[idx][5], cog[idx][6], cog[idx][7], cog[idx][0]

def turn(idx, n):
    if idx == 0:
        if cog[0][2] == cog[1][6]:
            spin(0, n)
        else:
            if cog[1][2] == cog[2][6]:
                spin(0, n)
                spin(1, -n)
            else:
                if cog[2][2] == cog[3][6]:
                    spin(0, n)
                    spin(1, -n)
                    spin(2, n)
                else:
                    spin(0, n)
                    spin(1, -n)
                    spin(2, n)
                    spin(3, -n)
    elif idx == 1:
        if cog[1][2] == cog[2][6]:
            if cog[0][2] == cog[1][6]:
                spin(1, n)
            else:
                spin(0, -n)
                spin(1, n)
        else:
            if cog[0][2] == cog[1][6]:
                if cog[2][2] == cog[3][6]:
                    spin(1, n)
                    spin(2, -n)
                else:
                    spin(1, n)
                    spin(2, -n)
                    spin(3, n)
            else:
                if cog[2][2] == cog[3][6]:
                    spin(0, -n)
                    spin(1, n)
                    spin(2, -n)
                else:
                    spin(0, -n)
                    spin(1, n)
                    spin(2, -n)
                    spin(3, n)
    elif idx == 2:
        if cog[1][2] == cog[2][6]:
            if cog[2][2] == cog[3][6]:
                spin(2, n)
            else:
                spin(2, n)
                spin(3, -n)
        else:
            if cog[2][2] == cog[3][6]:
                if cog[0][2] == cog[1][6]:
                    spin(1, -n)
                    spin(2, n)
                else:
                    spin(0, n)
                    spin(1, -n)
                    spin(2, n)
            else:
                if cog[0][2] == cog[1][6]:
                    spin(1, -n)
                    spin(2, n)
                    spin(3, -n)
                else:
                    spin(0, n)
                    spin(1, -n)
                    spin(2, n)
                    spin(3, -n)
    else:
        if cog[2][2] == cog[3][6]:
            spin(3, n)
        else:
            if cog[1][2] == cog[2][6]:
                spin(2, -n)
                spin(3, n)
            else:
                if cog[0][2] == cog[1][6]:
                    spin(1, n)
                    spin(2, -n)
                    spin(3, n)
                else:
                    spin(0, -n)
                    spin(1, n)
                    spin(2, -n)
                    spin(3, n)

cog = []
for i in range(4):
    cog.append(list(map(int, input())))

K = int(input())
for i in range(K):
    x, y = map(int, input().split())
    turn(x-1, y)

answer = 0
for i in range(4):
    if cog[i][0] == 1:
        answer += 2**i
print(answer)