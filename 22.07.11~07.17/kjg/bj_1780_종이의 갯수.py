import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
n = int(input())
world = [list(map(int,input().split())) for _ in range(n)]
M, Z, P = 0, 0, 0

def recursion(y, x, n):
    global M,Z,P
    # print('!!',y,x,n)
    a = world[y][x]
    cha = False
    for i in range(y, y + n):
        for j in range(x, x + n):
            if world[i][j] != a:
                cha = True
                break
        if cha:
            break
    if cha:
        # print('!',y,x, n)
        b = n // 3
        for i in range(3):
            for j in range(3):
                recursion(y + (b * i), x + (b * j), b)
    else:
        if a == -1:
            M += 1
        elif a == 0:
            Z += 1
        elif a == 1:
            P += 1

recursion(0, 0, n)
print(M)
print(Z)
print(P)